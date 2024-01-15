package com.clo.closs.data.sources

interface PreferencesSource {
    suspend fun saveStringPreference(key: String, value: String)
    suspend fun saveBooleanPreference(key: String, value: Boolean)
    suspend fun getStringPreference(key: String): String?
    suspend fun getBooleanPreference(key: String): Boolean?
    suspend fun clearPreferences(key: String)
}
