package com.sandoval.bogosunny.ui.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class AboutActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AboutActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        icon_attribution.setHtml("<div>App icon made by Juan Camilo Sandoval Devia</div>")

        api_attribution.setHtml("Powered By <a href=\"https://openweathermap.org\" title=\"openWeatherMap\">OpenWeatherMap</a>")

        widget_icon_attribution.setHtml("<div>Widget Icons made by <a href=\"https://www.flaticon.com/authors/good-ware\" title=\"Good Ware\">Good Ware</a> from <a href=\"https://www.flaticon.com/\" title=\"Flaticon\">www.flaticon.com</a> is licensed by <a href=\"http://creativecommons.org/licenses/by/3.0/\" title=\"Creative Commons BY 3.0\" target=\"_blank\">CC 3.0 BY</a></div>")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}