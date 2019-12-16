package com.sandoval.bogosunny.ui.saved_cities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_saved_cities.*

class SavedCitiesActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, SavedCitiesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_cities)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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