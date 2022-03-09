package com.example.picsumproject.repository

import com.example.picsumproject.model.PicSumList
import retrofit2.Response

class PicSumAPIService {

    suspend fun getPicSumApi(page: Int = 1, limit: Int = 10): Response<PicSumList> {
        return RetrofitBuilder().retrofit.create(PicSumAPI::class.java).getPicSumList(page, limit)
    }

}