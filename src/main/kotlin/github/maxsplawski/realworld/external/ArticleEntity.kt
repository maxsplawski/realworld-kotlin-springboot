package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleId
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("Article")
@Document("articles")
data class ArticleEntity(
    @Id val id: ObjectId = ObjectId.get(),
    val title: String,
    val description: String,
    val body: String,
) {
    companion object {
        fun from(article: Article) =
            ArticleEntity(
                ObjectId(article.id.value),
                article.title,
                article.description,
                article.body,
            )
    }
}

fun ArticleEntity.toDomain() =
    Article(
        id = ArticleId(id.toString()),
        title = title,
        description = description,
        body = body,
    )