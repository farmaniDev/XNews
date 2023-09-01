package com.farmani.xnews

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    // Based on documentation we need "top-headlines"
    @GET("top-headlines")
    /*
    Response is from retrofit Library
    add suspend because we are going to use it in coroutine
     */
    suspend fun getNews(
        @Query("source") source: String,
        @Query("apiKey") apiKey: String
    ): Response<ResponseModel>
}