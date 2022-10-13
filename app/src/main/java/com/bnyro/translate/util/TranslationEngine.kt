package com.bnyro.translate.util

import com.bnyro.translate.api.APIHelper

open class TranslationEngine(
    val name: String,
    val defaultUrl: String,
    val urlModifiable: Boolean,
    val apiKeyState: Int
) {
    lateinit var apiHelper: APIHelper

    val urlPrefKey = this.name + Preferences.instanceUrlKey
    val apiPrefKey = this.name + Preferences.apiKey
    fun getUrl() = Preferences.get(
        urlPrefKey,
        this.defaultUrl
    )

    fun getApiKey() = Preferences.get(
        apiPrefKey,
        ""
    )
}
