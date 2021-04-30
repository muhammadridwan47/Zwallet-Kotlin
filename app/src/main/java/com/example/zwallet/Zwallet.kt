package com.example.zwallet

import android.content.SharedPreferences
import androidx.multidex.MultiDexApplication
import androidx.preference.PreferenceManager
import com.example.zwallet.network.HttpClient

class Zwallet: MultiDexApplication() {
    companion object {
        lateinit var instance : Zwallet

        fun getApp() : Zwallet {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getPreferences() : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(this)
    }

    fun setToken(token: String) {
        getPreferences().edit().putString("PREFERENCES_TOKEN",token).apply()
        HttpClient.getInstance().buildRetrovitClient(token)
    }

    fun getToken(): String? {
        return getPreferences().getString("PREFERENCES_TOKEN",null)
    }

    fun setUser(user: String) {
        getPreferences().edit().putString("PREFERENCES_USER",user).apply()
        HttpClient.getInstance().buildRetrovitClient(user)
    }

    fun getUser(): String? {
        return getPreferences().getString("PREFERENCES_USER",null)
    }
}