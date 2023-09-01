package com.farmani.xnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(var newsList: MutableList<News>, var context: Context) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val author: TextView
        val date: TextView
        val cover: ImageView

        // This method is called on instantiating of ViewHolder class
        init {
            // This is more convenient than view.findViewById()
            view.apply {
                title = findViewById(R.id.titleTextView)
                description = findViewById(R.id.descriptionTextView)
                date = findViewById(R.id.dateTextView)
                author = findViewById(R.id.authorTextView)
                cover = findViewById(R.id.coverImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = newsList[position].title
            description.text = newsList[position].description
            author.text = newsList[position].author
            date.text = newsList[position].publishedAt
            Glide.with(context).load(newsList[position].urlToImage).into(cover)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}