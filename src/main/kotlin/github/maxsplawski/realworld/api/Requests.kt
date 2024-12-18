package github.maxsplawski.realworld.api

data class ArticlesRequest(
    val offset: Int?,
    val limit: Int?,
    val favorited: String?,
    val author: String?,
    val tag: String?,
)

data class CreateArticleRequest(
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
)

data class UpdateArticleRequest(
    val title: String?,
    val description: String?,
    val body: String?,
)

data class CreateCommentRequest(val body: String)