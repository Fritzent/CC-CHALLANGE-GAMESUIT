package com.example.codechallange_gamesuit.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.codechallange_gamesuit.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var bindingLogin: ActivityLoginBinding

    companion object{
        const val SP_NAMA = "user_data"
        const val FIELD_USERNAME = "username"
        const val FIELD_PASSWORD = "password"
        const val FIELD_EMAIL = "email"
        const val STATUS = "status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        val viewLogin = bindingLogin.root
        setContentView(viewLogin)

        val sharedPreferences = getSharedPreferences(SP_NAMA, Context.MODE_PRIVATE)
        val usernameInSp = sharedPreferences.getString(FIELD_USERNAME, "sabrina")
        val passwordInSp = sharedPreferences.getString(FIELD_PASSWORD, "binar123")

        //here to set the default username and password in sharedpreferences
        bindingLogin.etUsername.setText(usernameInSp)
        bindingLogin.etPassword.setText(passwordInSp)

        bindingLogin.btnLogin.setOnClickListener {
            if(bindingLogin.etUsername.text.isNotEmpty() && bindingLogin.etPassword.text.isNotEmpty()){
                if( bindingLogin.etUsername.text.toString() == sharedPreferences.getString(FIELD_USERNAME, "sabrina")
                    && bindingLogin.etPassword.text.toString() == sharedPreferences.getString(FIELD_PASSWORD, "binar123")){

                    //here to passing the status user is online
                    val editor = sharedPreferences.edit()
                    editor.putString(STATUS, "ONLINE")
                    //here to commit the edit
                    val statusCheck = editor.commit()

                    Log.d("DataUser",
                        "Status : $statusCheck Username : ${sharedPreferences.getString(FIELD_USERNAME, "sabrina")} Password : ${sharedPreferences.getString(FIELD_PASSWORD, "binar123")} Email : ${sharedPreferences.getString(FIELD_EMAIL, "sabrina@binar.co.id")}")
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }else {
                    Toast.makeText(this, "Username dan Password Tidak Ditemukan", Toast.LENGTH_LONG).show()
                }
            }else {
                Toast.makeText(this, "Username dan Password Wajib Diisi!", Toast.LENGTH_LONG).show()
            }
        }

        //TODO Still need improve
        //TODO How when click btnReset the value in the etUsername and etPassword its change to
        bindingLogin.btnReset.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(FIELD_USERNAME, "sabrina")
            editor.putString(FIELD_PASSWORD, "binar123")
            val statusCheckReset = editor.commit()

            if(statusCheckReset){
                bindingLogin.etUsername.setText(sharedPreferences.getString(FIELD_USERNAME, "not Found"))
                bindingLogin.etPassword.setText(sharedPreferences.getString(FIELD_PASSWORD, "binar123"))
            }else {
                Toast.makeText(this, "Gagal Melakukan Reset Data", Toast.LENGTH_LONG).show()
            }
        }
    }
}