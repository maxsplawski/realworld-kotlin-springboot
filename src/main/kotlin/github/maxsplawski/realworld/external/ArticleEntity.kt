package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article

data class ArticleEntity(
    val title: String,
    val description: String,
    val body: String,
)

fun ArticleEntity.toDomain() =
    Article(
        title = title,
        description = description,
        body = body,
    )