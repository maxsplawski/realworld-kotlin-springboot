package github.maxsplawski.realworld.api

data class ArticlesRequest(
    val offset: Int?,
    val limit: Int?,
    val favorited: String?,
    val author: String?,
    val tag: String?,
)
