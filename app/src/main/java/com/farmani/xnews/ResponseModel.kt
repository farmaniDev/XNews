package com.farmani.xnews

// To handle json response (the result of response) and is analyzed based on API
class ResponseModel(
    var status: String,
    var totalResult: Int,
    var article: List<News>
) {
}