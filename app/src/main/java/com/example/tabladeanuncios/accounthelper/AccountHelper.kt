package com.example.tabladeanuncios.accounthelper

import android.widget.Toast
import com.example.tabladeanuncios.MainActivity
import com.example.tabladeanuncios.R
import com.google.firebase.auth.FirebaseUser

class AccountHelper(act: MainActivity) {

    private val act = act

    fun signUpWithEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        sendEmailVerification(task.result?.user!!)
                        act.uiUpdate(task.result?.user)
                    } else {
                        Toast
                            .makeText(act,
                                act.resources.getString(R.string.sign_up_error),
                                Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }

    fun signInWithEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        act.uiUpdate(task.result?.user)
                    } else {
                        Toast
                            .makeText(act,
                                act.resources.getString(R.string.sign_in_error),
                                Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }

    private fun sendEmailVerification(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast
                    .makeText(act, act.resources.getString(R.string.send_verification_done), Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast
                    .makeText(act, act.resources.getString(R.string.send_verification_error), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}