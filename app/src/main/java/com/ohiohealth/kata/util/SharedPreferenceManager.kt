package com.ohiohealth.kata.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPreferenceManager(foContext: Context) {
    private var moSharedPreferences: SharedPreferences? =
        PreferenceManager.getDefaultSharedPreferences(foContext.applicationContext)

    fun clear() {
        moSharedPreferences!!.edit().clear().apply()
    }

    fun putString(key: String, fsValue: String) {
        if (moSharedPreferences != null) {
            val loEditor = moSharedPreferences!!.edit()
            loEditor.putString(key, fsValue)
            loEditor.apply()
        }
    }

    fun getString(key: String): String {
        return if (moSharedPreferences != null) moSharedPreferences!!.getString(key, "")
            .toString() else ""
    }

    companion object {
        const val USER_DATA = "UserData"
    }
}