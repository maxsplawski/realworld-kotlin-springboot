package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import org.bson.types.ObjectId

data class Article(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
) {
    companion object {
        fun from(dto: ArticleDto) = Article(
            id = ArticleId(dto.id),
            title = dto.title,
            description = dto.description,
            body = dto.body,
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