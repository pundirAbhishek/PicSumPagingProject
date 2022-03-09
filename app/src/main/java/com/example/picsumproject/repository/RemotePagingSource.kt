package com.example.picsumproject.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.picsumproject.model.PicSumList
import com.example.picsumproject.model.PicSumListItem

//class RemotePagingSource(val service: PicSumAPIService) : PagingSource<Int, PicSumListItem>() {
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PicSumListItem> {
//        try {
//            val page = params.key ?: 1
//            val response = service.getPicSumApi(page)
//            return LoadResult.Page(
//                data = response.body(),
//                prevKey = page - 1,
//                nextKey = page + 1
//            )
//        } catch (e: Exception) {
//            return LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, PicSumListItem>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}