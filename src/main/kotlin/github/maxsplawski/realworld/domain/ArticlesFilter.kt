package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticlesRequest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

data class ArticlesFilter(
    val pageable: Pageable,
    val favorited: String?,
    val author: String?,
    val tag: String?,
) {
    companion object {
        fun from(articlesRequest: ArticlesRequest) =
            ArticlesFilter(
                pageable = PageRequest.of(
                    articlesRequest.offset ?: OFFSET,
                    articlesRequest.limit ?: LIMIT,
                    Sort.by(Sort.Direction.ASC, CREATED_AT_FIELD),
                ),
                favorited = articlesRequest.favorited,
                author = articlesRequest.author,
                tag = articlesRequest.tag,
            )

        private const val OFFSET = 0;
        private const val LIMIT = 20;
        private const val CREATED_AT_FIELD = "createdAt";
    }
}