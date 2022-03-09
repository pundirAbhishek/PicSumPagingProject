package com.example.picsumproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.picsumproject.model.PicSumList


class PicSumFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pic_sum, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.getPicSumData().observe(viewLifecycleOwner) { picSumList ->
            if (picSumList.isNullOrEmpty()) {
                // Handle Null Cases
            } else {
                setUpRecyclerView(picSumList)
            }
        }
    }

    private fun setUpRecyclerView(picSumList: PicSumList) {
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(
            requireView().context,
            LinearLayoutManager.VERTICAL,
            false
        );
        recyclerView.adapter = PicSumImagesAdapter(picSumList)
    }

}
