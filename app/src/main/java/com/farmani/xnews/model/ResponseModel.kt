package com.farmani.xnews.model

// To handle json response (the result of response) and is analyzed based on API
class ResponseModel(
    var status: String,
    var totalResult: Int,
    var articles: List<News>
) {
}