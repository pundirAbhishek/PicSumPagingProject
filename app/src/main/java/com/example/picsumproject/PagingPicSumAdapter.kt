package com.example.picsumproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.picsumproject.databinding.PicSumImageItemBinding
import com.example.picsumproject.model.PicSumListItem


class PagingPicSumAdapter(differCallback: DiffUtil.ItemCallback<PicSumListItem>) :
    PagingDataAdapter<PicSumListItem, PagingPicSumAdapter.PagingPicSumImagesViewHolder>(
        differCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PagingPicSumImagesViewHolder {
        val binding =
            PicSumImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PagingPicSumImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagingPicSumImagesViewHolder, position: Int) {
        val item = getItem(position)
        if (item == null) {
            // add placeHolder
        } else {
            holder.bind(item)
        }
    }

    class PagingPicSumImagesViewHolder(private val binding: PicSumImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(picSumInfoModel: PicSumListItem) {

            Glide.with(binding.root.context)
                .load(picSumInfoModel.download_url) // image url
                .centerCrop()
                .into(binding.picSumImage);

            binding.picSumImage.setOnClickListener {
                openDetailedFragment(picSumInfoModel)
            }

        }


        private fun openDetailedFragment(picSumInfoModel: PicSumListItem) {
            val fragment = FullImageFragment()
            val bundle = Bundle()
            bundle.putParcelable(picInfoModelArg, picSumInfoModel)
            fragment.arguments = bundle
            switchContent(fragment)
        }

        private fun switchContent(fragment: Fragment) {
            val context = binding.root.context ?: return
            if (context is MainActivity) {
                val frag: Fragment = fragment
                context.switchContent(frag)
            }
        }
    }


}
