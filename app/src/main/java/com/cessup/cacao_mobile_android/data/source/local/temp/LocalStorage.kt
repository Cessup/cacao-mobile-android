package com.cessup.cacao_mobile_android.data.source.local.temp

/**
 * LocalStorage is an interface about save some values in a Local Storage
 *
 * There are function to help to save the values
 *
 * @author
 *     Cessup
 * @since 1.0
 */
interface LocalStorage {
    /**
     * This function save a user in the user table.
     *
     * @param token unique identifier about session from server.
     */
    fun saveToken(token: String)
    /**
     * This function give a user in the user table.
     *
     * @return String that is the token about session from server.
     */
    fun readToken(): String?
}