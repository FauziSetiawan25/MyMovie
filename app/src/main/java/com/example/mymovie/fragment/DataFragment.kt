package com.example.mymovie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovie.MovieAdapter
import com.example.mymovie.R
import com.example.mymovie.RClient
import com.example.mymovie.databinding.FragmentDataBinding
import com.example.mymovie.modeldata.MovieData
import com.example.mymovie.modeldata.SearchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataFragment : Fragment() {
    private var _binding: FragmentDataBinding? = null

    private val binding get() = _binding!!

    private val list = ArrayList<MovieData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycleData.setHasFixedSize(true)
        binding.recycleData.layoutManager =LinearLayoutManager(context)

        RClient.instances.getMovies().enqueue(object : Callback<SearchData>{
            override fun onResponse(p0: Call<SearchData>, p1: Response<SearchData>) {
                val response = p1.code()

                p1.body()?.let { list.addAll(it.data) }
                val adapter = MovieAdapter(list)
                binding.recycleData.adapter = adapter
            }

            override fun onFailure(p0: Call<SearchData>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}