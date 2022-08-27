package com.example.a621k.Manager

import android.content.Context
import android.content.SharedPreferences

class PrefsManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences?

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    }

    fun saveData(key: Int, value: Int) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putInt(key.toString(), value)
        prefsEditor.apply()
    }

    fun getData(key: Int?): Int {
        return sharedPreferences?.getInt(key.toString(), 1) ?: 1
    }

    fun saveDataLong(key: Int, value: Long) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putLong(key.toString(), value)
        prefsEditor.apply()
    }

    fun getDataLong(key: Int?): Long {
        return sharedPreferences?.getLong(key.toString(), 1) ?: 0
    }

    fun saveDataBoolean(key: Int, value: Boolean) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putBoolean(key.toString(), value)
        prefsEditor.apply()
    }

    fun getDataBoolean(key: Int?): Boolean {
        return sharedPreferences?.getBoolean(key.toString(), true) ?: false
    }
}