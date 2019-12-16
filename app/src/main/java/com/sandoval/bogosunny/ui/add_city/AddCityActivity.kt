package com.sandoval.bogosunny.ui.add_city

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_city.*
import javax.inject.Inject

class AddCityActivity : BaseActivity(), CityListAdapter.Callback {

    @Inject
    lateinit var cityListAdapter: CityListAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var allCityArrayList: MutableList<String>
    private lateinit var suggestionsArrayList: MutableList<String>
    private lateinit var addCityViewModel: AddCityViewModel

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AddCityActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        addCityViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        )[AddCityViewModel::class.java]

        cityListAdapter.setCallBack(this@AddCityActivity)
        init()
    }

    private fun init() {
        city_list.layoutManager = LinearLayoutManager(this@AddCityActivity)
        city_list.adapter = cityListAdapter

        val cityArray = resources.getStringArray(R.array.top_places)
        allCityArrayList = cityArray.toMutableList()
        suggestionsArrayList = cityArray.toMutableList()

        cityListAdapter.addCities(suggestionsArrayList)

        city_edit_text.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(S: Editable?) {
                suggestionsArrayList.clear()
                for (city in allCityArrayList) {
                    if (city.toLowerCase().startsWith(city_edit_text.text.toString().toLowerCase()))
                        suggestionsArrayList.add(city)
                }
                cityListAdapter.addCities(suggestionsArrayList)
            }
        })

        clear_button.setOnClickListener {
            city_edit_text.text?.clear()
        }
    }

    override fun onCityClick(city: String) {
        Toast.makeText(this@AddCityActivity, "City Clicked", Toast.LENGTH_LONG).show()
    }
}