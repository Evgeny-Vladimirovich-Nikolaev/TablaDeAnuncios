package com.example.tabladeanuncios.dialoghelper

import android.app.AlertDialog
import android.view.View
import com.example.tabladeanuncios.MainActivity
import com.example.tabladeanuncios.R
import com.example.tabladeanuncios.accounthelper.AccountHelper
import com.example.tabladeanuncios.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
    private val act = act
    private val accHelper = AccountHelper(act)
    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val binding = SignDialogBinding.inflate(act.layoutInflater)
        builder.setView(binding.root)
        if(index == DialogConst.SIGN_UP_STATE) {
            binding.tvSignTitle.text = act.resources.getText(R.string.ad_sign_up)
            binding.btSignUpIn.text = act.resources.getText(R.string.sing_up_action)
        } else {
            binding.tvSignTitle.text = act.resources.getText(R.string.ad_sign_in)
            binding.btSignUpIn.text = act.resources.getText(R.string.sing_in_action)
            binding.btForgetPass.visibility = View.VISIBLE
        }
        val dialog = builder.create()
        binding.btSignUpIn.setOnClickListener {
            dialog.dismiss()
            if(index == DialogConst.SIGN_UP_STATE) {
                accHelper.signUpWithEmail(
                    binding.edSignEmail.text.toString(),
                    binding.edSignPassword.text.toString())
            }
            else {
                accHelper.signInWithEmail(
                    binding.edSignEmail.text.toString(),
                    binding.edSignPassword.text.toString())
            }
        }
        dialog.show()
    }
}