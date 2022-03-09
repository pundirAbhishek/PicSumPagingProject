package com.example.picsumproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PicSumListItem(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
) : Parcelable