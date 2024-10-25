package github.maxsplawski.realworld.api

data class CreateArticleRequest(
    val title: String,
    val description: String,
    val body: String,
)
