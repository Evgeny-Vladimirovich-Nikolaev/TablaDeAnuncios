package com.example.tabladeanuncios.dialoghelper

import android.app.AlertDialog
import com.example.tabladeanuncios.MainActivity
import com.example.tabladeanuncios.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
    private val act = act
    fun createSignDialog() {
        val builder = AlertDialog.Builder(act)
        val binding = SignDialogBinding.inflate(act.layoutInflater)
        builder.setView(binding.root)
        builder.show()
    }
}