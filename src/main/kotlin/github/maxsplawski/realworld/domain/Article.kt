package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto

data class Article(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
)

@JvmInline
value class ArticleId(val value: String)

fun Article.toDto() =
    ArticleDto(
        id = id.value,
        title = title,
        description = description,
        body = body,
    )