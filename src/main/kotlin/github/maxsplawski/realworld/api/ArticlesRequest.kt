package github.maxsplawski.realworld.api

data class ArticlesRequest(
    val offset: Int? = null,
    val limit: Int? = null,
    val favorited: String? = null,
    val author: String? = null,
    val tag: String? = null,
)
