package com.example.picsumproject

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.picsumproject.databinding.PicSumImageItemBinding
import com.example.picsumproject.model.PicSumList
import com.example.picsumproject.model.PicSumListItem


class PicSumImagesAdapter(private val itemsList: PicSumList) :
    RecyclerView.Adapter<PicSumImagesAdapter.PicSumImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicSumImagesViewHolder {
        val binding =
            PicSumImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PicSumImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicSumImagesViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class PicSumImagesViewHolder(private val binding: PicSumImageItemBinding) :
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
