/*
 * Copyright (c) 2023 You Apps
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.bnyro.translate.api.st

import com.bnyro.translate.api.st.obj.STTranslationResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimplyTranslate {
    @GET("api/translate/")
    suspend fun translate(
        @Query("engine") engine: String? = null,
        @Query("from") source: String,
        @Query("to") target: String,
        @Query("text") query: String
    ): STTranslationResponse

    @GET("api/target_languages/")
    suspend fun getLanguages(
        @Query("engine") engine: String?
    ): Map<String, String>

    @GET("api/tts")
    suspend fun getAudioFile(
        @Query("engine") engine: String? = "google",
        @Query("lang") lang: String,
        @Query("text") text: String
    ): Response<ResponseBody>
}
