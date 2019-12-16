package com.sandoval.bogosunny.ui.weather

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.about.AboutActivity
import com.sandoval.bogosunny.ui.add_city.AddCityActivity
import com.sandoval.bogosunny.ui.base.BaseActivity
import com.sandoval.bogosunny.ui.saved_cities.SavedCitiesActivity
import com.sandoval.bogosunny.utils.AppConstants
import com.sandoval.bogosunny.utils.AppConstants.LOCATION_PERMISSION_REQUEST
import com.sandoval.bogosunny.utils.AppConstants.REQUEST_ADD_CITY
import com.sandoval.bogosunny.utils.AppConstants.REQUEST_CHECK_SETTINGS
import com.sandoval.bogosunny.utils.AppConstants.REQUEST_REMOVE_CITY
import com.sandoval.bogosunny.utils.ThemeUtils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar
import org.greenrobot.eventbus.EventBus
import timber.log.Timber
import java.lang.Exception
import java.util.jar.Manifest

class WeatherActivity : BaseActivity(), OnSuccessListener<LocationSettingsResponse>,
    OnFailureListener {

    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null
    private var fusedLocationClient: FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        if (ThemeUtils.isNight())
            changeRings()
        animateSunAndMoon()

        add_city_button.setOnClickListener {
            startActivityForResult(
                AddCityActivity.getStartIntent(this@WeatherActivity), REQUEST_ADD_CITY
            )
        }
    }

    private fun changeRings() {
        rings.setBackgroundResource(R.drawable.circular_rings_dark)
        sun_and_moon.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
        add_city_button.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#403C48"))
    }

    private fun animateSunAndMoon() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        val animation = ObjectAnimator.ofFloat(sun_and_moon, "translationX", width.toFloat())
        animation.duration = 5000
        animation.repeatCount = ValueAnimator.INFINITE
        animation.repeatMode = ValueAnimator.REVERSE
        animation.start()
    }

    public override fun onResume() {
        super.onResume()
        if (hasPermissions(
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        ) {
            checkLocationSettings()
        } else {
            requestPermissionsSafely(
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )
                , LOCATION_PERMISSION_REQUEST
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.size == 2 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {
                checkLocationSettings()
            } else Toast.makeText(this, "Permission Denied.", Toast.LENGTH_LONG).show()
        } else super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkLocationSettings() {
        locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        locationRequest?.let {
            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(it)
                .setAlwaysShow(true)

            val client: SettingsClient = LocationServices.getSettingsClient(this)
            val task: Task<LocationSettingsResponse> =
                client.checkLocationSettings(builder?.build())

            task.addOnSuccessListener(this@WeatherActivity)
            task.addOnFailureListener(this@WeatherActivity)
        }
    }

    override fun onSuccess(locationSettingsResponse: LocationSettingsResponse?) {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                Timber.d("Location : ${locationResult.locations[0].latitude}, ${locationResult.locations[0].longitude} ")
            }
        }
        fusedLocationClient = FusedLocationProviderClient(this@WeatherActivity)
        fusedLocationClient?.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }

    override fun onFailure(exception: Exception) {
        if (exception is ResolvableApiException) {
            try {
                exception.startResolutionForResult(this@WeatherActivity, REQUEST_CHECK_SETTINGS)
            } catch (sendEx: IntentSender.SendIntentException) {
                Timber.e(sendEx)
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CHECK_SETTINGS -> when (resultCode) {
                Activity.RESULT_OK -> Timber.d("User Agreed to make required location settings changes. ")
                Activity.RESULT_CANCELED -> {
                    checkLocationSettings()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    private fun stopLocationUpdates() {
        fusedLocationClient?.removeLocationUpdates(locationCallback)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_weather_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.saved_cities -> {
                startActivityForResult(
                    SavedCitiesActivity.getStartIntent(this@WeatherActivity),
                    REQUEST_REMOVE_CITY
                )
                true
            }
            R.id.about -> {
                startActivity(AboutActivity.getStartIntent(this@WeatherActivity))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
