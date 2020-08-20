package com.example.codechallange_gamesuit.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.codechallange_gamesuit.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var bindingProfile: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingProfile = ActivityProfileBinding.inflate(layoutInflater)
        val viewProfile = bindingProfile.root
        setContentView(viewProfile)

        val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAMA, Context.MODE_PRIVATE)
        val usernameInSp = sharedPreferences.getString(LoginActivity.FIELD_USERNAME, "sabrina")
        val emailInSp = sharedPreferences.getString(LoginActivity.FIELD_EMAIL, "sabrina@binar.co.id")

        val editor = sharedPreferences.edit()

        //here to get the name from SharedPreferences
        bindingProfile.etUsernameValue.setText(usernameInSp)
        bindingProfile.etEmailValue.setText(emailInSp)

        //here to change a email in data profile
        bindingProfile.etEmailValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                editor.putString(LoginActivity.FIELD_EMAIL, bindingProfile.etEmailValue.text.toString())
                val checkStatusEmail = editor.commit()

                Log.d("DataUserNow", "status: $checkStatusEmail Email: ${sharedPreferences.getString(LoginActivity.FIELD_EMAIL, "Not Found")}")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        //here to change a username in data profile
        bindingProfile.etUsernameValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                editor.putString(LoginActivity.FIELD_USERNAME, bindingProfile.etUsernameValue.text.toString())
                val checkStatusUsername = editor.commit()

                Log.d("DataUserNow", "status: $checkStatusUsername UsernameNow: ${sharedPreferences.getString(LoginActivity.FIELD_USERNAME, "sabrina")}")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                bindingProfile.etUsernameValue.text.toString()
            }
        })

    }
}