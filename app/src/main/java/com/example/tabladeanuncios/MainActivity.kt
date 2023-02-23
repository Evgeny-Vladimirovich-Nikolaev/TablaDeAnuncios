package com.example.tabladeanuncios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener,
    NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.ad_my_ads -> {
                Toast.makeText(this, "Pressed ad_my_ads", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_car -> {
                Toast.makeText(this, "Pressed ad_car", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_pc -> {
                Toast.makeText(this, "Pressed ad_pc", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_smart -> {
                Toast.makeText(this, "Pressed ad_smart", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_dm -> {
                Toast.makeText(this, "Pressed ad_dm", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_sign_up -> {
                Toast.makeText(this, "Pressed ad_sign_up", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_sign_in -> {
                Toast.makeText(this, "Pressed ad_sign_in", Toast.LENGTH_LONG).show()
                //TODO
            }
            R.id.ad_sign_out -> {
                Toast.makeText(this, "Pressed ad_sign_out", Toast.LENGTH_LONG).show()
                //TODO
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

