package github.maxsplawski.realworld.api

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("article")
data class ArticleDto(
    val id: String,
    val title: String,
    val description: String,
    val body: String,
)
