package com.example.afinal.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source,
    val title: String? = null,
    val url: String? = null,
    var urlToImage: String? = null
){
    init {
        if (urlToImage == null)
            urlToImage = "https://www.medialaws.eu/wp-content/uploads/2020/05/News-media-standards-702x336.jpg"
    }
}

