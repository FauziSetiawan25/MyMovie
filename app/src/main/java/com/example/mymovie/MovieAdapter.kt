package com.example.mymovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovie.databinding.ListDataMovieBinding
import com.example.mymovie.modeldata.MovieData

class MovieAdapter (private val listMovie:ArrayList<MovieData>):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(itemView: ListDataMovieBinding):RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(movieData: MovieData){
            with(binding){
                Glide.with(itemView).load(movieData.gambar).into(imgPoster)
                title.text = movieData.Title
                year.text = movieData.Year
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ListDataMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}
