package com.example.picsumproject.repository

import com.example.picsumproject.model.PicSumList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicSumAPI {
    @GET("v2/list")
    suspend fun getPicSumList(@Query("page") page: Int, @Query("limit") limit: Int): Response<PicSumList>
}