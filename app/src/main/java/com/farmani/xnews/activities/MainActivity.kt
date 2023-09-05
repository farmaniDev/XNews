package com.farmani.xnews.activities

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farmani.xnews.api.API
import com.farmani.xnews.BuildConfig
import com.farmani.xnews.model.News
import com.farmani.xnews.adapter.NewsAdapter
import com.farmani.xnews.R
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val newsList = mutableListOf<News>()
    private val apiKey = BuildConfig.apiKey
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible = true
            val response =
                Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(API::class.java).getNews("techcrunch", apiKey)

            if (response.isSuccessful && response.body() != null) {
                newsList.addAll(response.body()!!.articles)
                initRecView()
                progressBar.isVisible = false
            } else {
                Log.e("TAG", "Nothing")
            }
        }
    }

    private fun initRecView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = NewsAdapter(newsList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

}