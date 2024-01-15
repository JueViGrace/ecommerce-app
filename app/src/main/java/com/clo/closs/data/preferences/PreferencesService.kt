package com.clo.closs.data.preferences

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.clo.closs.common.Constantes.DATASTORE_NAME
import com.clo.closs.data.sources.PreferencesSource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

class PreferencesService @Inject constructor(
    private val context: Context
) : PreferencesSource {
    override suspend fun saveStringPreference(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKey] = value
        }
    }

    override suspend fun saveBooleanPreference(key: String, value: Boolean) {
        val preferenceKey = booleanPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKey] = value
        }
    }

    override suspend fun getStringPreference(key: String): String? {
        return try {
            val preferenceKey = stringPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKey]
        } catch (e: NullPointerException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IllegalArgumentException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IndexOutOfBoundsException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IllegalStateException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        }
    }

    override suspend fun getBooleanPreference(key: String): Boolean? {
        return try {
            val preferenceKey = booleanPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKey]
        } catch (e: NullPointerException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IllegalArgumentException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IndexOutOfBoundsException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        } catch (e: IllegalStateException) {
            Log.e(e.localizedMessage, "Ha ocurrido un error ${e.message}", e.cause)
            null
        }
    }

    override suspend fun clearPreferences(key: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(preferenceKey)) {
                it.remove(preferenceKey)
            }
        }
    }
}
