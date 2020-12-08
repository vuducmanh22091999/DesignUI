package com.example.designui.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import com.example.designui.MainActivity
import com.example.designui.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initListener()
//        showPassword()
    }

    private fun initListener() {
        tvLogin.setOnClickListener(this)
    }

    private fun switchScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

//    private fun showPassword() {
//        etPassword.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (etPassword.text.isNotEmpty()) {
//                    imgShowPassword.visibility = View.VISIBLE
//                    imgShowPassword.setOnClickListener {
//                        etPassword.transformationMethod =
//                            HideReturnsTransformationMethod.getInstance()
//                    }
//                } else {
//                    imgShowPassword.visibility = View.INVISIBLE
//                }
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//        })
//    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvLogin -> switchScreen()
        }
    }
}