package com.example.a621k

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.a621k.Manager.PrefsManager

class PreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        initViews()
    }

    private fun initViews() {
        val et_pword= findViewById<EditText>(R.id.et_email)
        val b_save = findViewById<Button>(R.id.b_save)
        val b_save1 = findViewById<Button>(R.id.b_save1)
        val b_save2 = findViewById<Button>(R.id.b_save2)
        val b_save3 = findViewById<Button>(R.id.b_save3)

        b_save.setOnClickListener {

            val pword: Int = et_pword.text.toString().toInt()
            PrefsManager.getInstance(this)!!.saveData(1, pword)
            val data = PrefsManager.getInstance(this)!!.getData(1)
            saveEmail(data)

        }

        b_save1.setOnClickListener{
            val long: Long = et_pword.text.toString().toLong()
            PrefsManager.getInstance(this)!!.saveDataLong(1, long)
            val data1 = PrefsManager.getInstance(this)!!.getDataLong(1)
            saveLong(data1)
        }

        b_save2.setOnClickListener{
            val long: Boolean = et_pword.text.toString().toBoolean()
            PrefsManager.getInstance(this)!!.saveDataBoolean(1, long)
            val data1 = PrefsManager.getInstance(this)!!.getDataBoolean(1)
            saveBoolean(data1)
        }
    }

    private fun saveEmail(email: Int?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        if (email != null) {
            editor.putInt("email", email)
        }
        editor.apply()
    }

    private fun saveLong(email: Long?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        if (email != null) {
            editor.putLong("email", email)
        }
        editor.apply()
    }

    private fun saveBoolean(email: Boolean?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        if (email != null) {
            editor.putBoolean("email", email)
        }
        editor.apply()
    }
}