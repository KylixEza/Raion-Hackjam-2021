package com.timhore.raionhackjam2021.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Datastore(private val context: Context) {

    companion object {
        const val DATA_STORE_NAME = "App Data Store"
        val EMAIL_PREF_KEY = stringPreferencesKey("EMAIL_PREF_KEY")
    }

    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = DATA_STORE_NAME
    )

    suspend fun savePrefEmail(email: String) {
        context.userPreferenceDataStore.edit {
            it[EMAIL_PREF_KEY] = email
        }
    }

    /*suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) {
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.HAVE_RUN_APP_BEFORE] = isFirstTime
        }
    }*/

    fun readPrefEmail(): Flow<Boolean> = context.userPreferenceDataStore.data
        .map {
            it[EMAIL_PREF_KEY] != "null"
        }

    /*fun readPrefHaveRunAppBefore(): Flow<Boolean> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.HAVE_RUN_APP_BEFORE] != null
        }*/
}