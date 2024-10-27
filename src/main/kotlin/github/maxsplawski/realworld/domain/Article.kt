package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import github.maxsplawski.realworld.api.CreateArticleRequest
import github.maxsplawski.realworld.api.UpdateArticleRequest
import org.bson.types.ObjectId
import java.time.Instant

data class Article(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
    val createdAt: Instant,
    val updatedAt: Instant,
) {
    companion object {
        fun from(createArticleRequest: CreateArticleRequest) = Article(
            id = ObjectId().toArticleId(),
            title = createArticleRequest.title,
            description = createArticleRequest.description,
            body = createArticleRequest.body,
            tagList = createArticleRequest.tagList,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }
}

data class ArticleUpdate(
    val title: String?,
    val description: String?,
    val body: String?,
) {
    companion object {
        fun from(updateArticleRequest: UpdateArticleRequest) = ArticleUpdate(
            title = updateArticleRequest.title,
            description = updateArticleRequest.description,
            body = updateArticleRequest.body,
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
        tagList = tagList,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )

fun ArticleId.toObjectId() = ObjectId(this.value)

fun ObjectId.toArticleId() = ArticleId(this.toString())