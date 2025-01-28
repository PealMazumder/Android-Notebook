package com.peal.androidnotebook.kotlinDelegates

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by Peal Mazumder on 28/1/25.
 */

// Basic implementation of a custom sharedPreferences delegate
class SharedPreferencesDelegate<T>(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defaultValue: T
) {
    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (defaultValue) {
            is String -> sharedPreferences.getString(key, defaultValue) as T
            is Int -> sharedPreferences.getInt(key, defaultValue) as T
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue) as T
            is Float -> sharedPreferences.getFloat(key, defaultValue) as T
            is Long -> sharedPreferences.getLong(key, defaultValue) as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        with(sharedPreferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
            apply()
        }
    }
}

// Create a Wrapper Class
class AppPreferences(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    var username: String by SharedPreferencesDelegate(sharedPreferences, "username", "Guest")
    var isLoggedIn: Boolean by SharedPreferencesDelegate(sharedPreferences, "isLoggedIn", false)
    var highScore: Int by SharedPreferencesDelegate(sharedPreferences, "highScore", 0)
}
