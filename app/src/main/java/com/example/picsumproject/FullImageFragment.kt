package com.example.picsumproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.picsumproject.model.PicSumListItem

const val picInfoModelArg = "param1"

class FullImageFragment : Fragment() {
    private var picInfoModel: PicSumListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            picInfoModel = it.getParcelable(picInfoModelArg)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = requireView().findViewById(R.id.imageView);

        picInfoModel?.let {
            Glide.with(view.context)
                .load(it.download_url) // image url
                .centerCrop()
                .into(imageView);
        }

    }
}