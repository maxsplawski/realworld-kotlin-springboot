package github.maxsplawski.realworld.domain

data class Article(
    val id: ArticleId,
    val title: String,
    val description: String,
    val body: String,
)

@JvmInline
value class ArticleId(val value: String)