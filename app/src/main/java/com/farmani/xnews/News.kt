package com.farmani.xnews

data class News(
    var title: String,
    var description: String,
    var date: String,
    var author: String,
    var imageUrl: String,
    var linkUrl: String
) {
}