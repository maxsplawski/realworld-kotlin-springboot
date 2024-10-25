package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import github.maxsplawski.realworld.api.CreateArticleRequest
import org.bson.types.ObjectId

data class Article(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
) {
    companion object {
        fun from(requestBody: CreateArticleRequest) = Article(
            id = ArticleId(ObjectId().toString()),
            title = requestBody.title,
            description = requestBody.description,
            body = requestBody.body,
        )
    }
}

@JvmInline
value class ArticleId(val value: String)

fun Article.toDto() =
    ArticleDto(
        id = id.value,
        title = title,
        description = description,
        body = body,
    )

fun ArticleId.toObjectId() = ObjectId(this.value)