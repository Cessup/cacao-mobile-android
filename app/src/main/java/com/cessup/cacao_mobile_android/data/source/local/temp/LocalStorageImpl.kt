package com.cessup.cacao_mobile_android.data.source.local.temp

import android.content.Context
import android.content.Context.MODE_PRIVATE

/**
 * LocalStorage is an object about save some values in a Local Storage
 *
 * There are function to help to save the values
 *
 * @author
 *     Cessup
 * @since 1.0
 */
class LocalStorageImpl(context: Context) :LocalStorage {
    val sharedPref = context.getSharedPreferences(ShareValues.PREFERENCES.name, MODE_PRIVATE)
    val editor = sharedPref.edit()

    /**
     * This function save a user in the user table.
     *
     * @property token unique identifier about session from server.
     */
    override fun saveToken(token: String) {
        editor.putString(ShareValues.TOKEN.name, token)
        editor.apply()
    }
    /**
     * This function give a user in the user table.
     *
     * @return String that is the token about session from server.
     */
    override fun readToken(): String? {
        return sharedPref.getString(ShareValues.TOKEN.name, ShareValues.VOID.name)
    }
}