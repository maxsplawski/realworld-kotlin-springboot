package github.maxsplawski.realworld.api

import java.time.Instant

data class ArticleDto(
    val id: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
    val createdAt: Instant,
    val updatedAt: Instant,
)
