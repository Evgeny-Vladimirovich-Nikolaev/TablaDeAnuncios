package com.example.tabladeanuncios

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.tabladeanuncios.databinding.ActivityMainBinding
import com.example.tabladeanuncios.dialoghelper.DialogConst
import com.example.tabladeanuncios.dialoghelper.DialogHelper
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tvAccount: TextView
    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this,
            binding.drawerLayout,
            binding.mainContent.toolbar,
            R.string.open,
            R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
        tvAccount = binding.navView.getHeaderView(0).findViewById(R.id.tvAccountEmail)
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
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            R.id.ad_sign_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }
            R.id.ad_sign_out -> {
                mAuth.signOut()
                uiUpdate(null)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?) {
        tvAccount.text = if(user == null) {
            resources.getString(R.string.not_reg)
        } else {
            user.email
        }
    }
}

