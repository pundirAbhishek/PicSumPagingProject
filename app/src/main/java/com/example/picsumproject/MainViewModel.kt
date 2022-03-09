package com.example.picsumproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.picsumproject.model.PicSumList
import com.example.picsumproject.repository.PicSumAPIService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
            loadPicSumData()
        }
    }

//    val picSumData: LiveData<PagingData<PicSumList>> = Pager(
//        config = PagingConfig(pageSize = 10)
//    ) {
//        RemotePagingSource(service = PicSumAPIService())
//    }.liveData


    private val getPicSumData = MutableLiveData<PicSumList?>()

    fun getPicSumData(): LiveData<PicSumList?> {
        return getPicSumData
    }

    private suspend fun loadPicSumData() {
        val response = PicSumAPIService().getPicSumApi()
        if (response.isSuccessful) {
            getPicSumData.postValue(response.body())
        } else {
            getPicSumData.postValue(null)
        }

    }
}
