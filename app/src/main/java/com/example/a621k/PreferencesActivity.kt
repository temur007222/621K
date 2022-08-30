package com.example.a621k

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preference.*
import java.lang.Double.doubleToRawLongBits

class PreferencesActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE)

        b_save.setOnClickListener{
            val emailValue = et_email.text.toString().toInt()

            val editor = sharedPreferences?.edit()
            editor?.putInt("emailValue", emailValue)
            editor?.apply()

            val getEmailValue: Int? = sharedPreferences?.getInt("emailValue", emailValue)
            et1.setText(getEmailValue.toString())
        }

        b_save1.setOnClickListener{
            val emailValue = dable.text.toString()

            val editor = sharedPreferences?.edit()
            editor?.putString("emailValue", emailValue)
            editor?.apply()

            val getEmailValue: String? = sharedPreferences?.getString("emailValue", emailValue)
            et2.setText(getEmailValue)
        }

        b_save2.setOnClickListener{
            val emailValue = bool.text.toString().toBoolean()

            val editor = sharedPreferences?.edit()
            editor?.putBoolean("emailValue", emailValue)
            editor?.apply()

            val getEmailValue: Boolean? = sharedPreferences?.getBoolean("emailValue", emailValue)
            et3.setText(getEmailValue.toString())
        }

        b_save3.setOnClickListener{
            val emailValue = bool.text.toString().toLong()

            val editor = sharedPreferences?.edit()
            editor?.putLong("emailValue", emailValue)
            editor?.apply()

            val getEmailValue: Long? = sharedPreferences?.getLong("emailValue", emailValue)
            et4.setText(getEmailValue.toString())
        }
    }

}