package com.example.tabladeanuncios.accounthelper

import android.widget.Toast
import com.example.tabladeanuncios.MainActivity
import com.example.tabladeanuncios.R

class AccountHelper(act: MainActivity) {

    private val act = act

    fun signUpWithEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                    } else {
                        Toast
                            .makeText(act, act.resources.getString(R.string.sign_up_error), Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }
}