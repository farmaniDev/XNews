package com.farmani.xnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val newsList = mutableListOf<News>()
    private val apiKey = BuildConfig.apiKey
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecView()
        lifecycleScope.launch {
            val response =
                Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(API::class.java).getNews("techcrunch", apiKey)
        }
    }

    private fun initRecView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = NewsAdapter(newsList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}