package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleId
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@TypeAlias("Article")
@Document("articles")
data class ArticleEntity(
    @Id val id: ObjectId = ObjectId.get(),
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
    val createdAt: Instant,
    val updatedAt: Instant,
) {
    companion object {
        fun from(article: Article) =
            ArticleEntity(
                id = ObjectId(article.id.value),
                title = article.title,
                description = article.description,
                body = article.body,
                tagList = article.tagList,
                createdAt = article.createdAt,
                updatedAt = article.updatedAt,
            )
    }
}

fun ArticleEntity.toDomain() =
    Article(
        id = ArticleId(id.toString()),
        title = title,
        description = description,
        body = body,
        tagList = tagList,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )