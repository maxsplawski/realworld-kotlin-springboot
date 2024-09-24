package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticlesRequest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

data class ArticlesFilter(
    val pageable: Pageable,
) {
    companion object {
        fun from(articlesRequest: ArticlesRequest) =
            ArticlesFilter(
                pageable = PageRequest.of(
                    articlesRequest.offset ?: 0,
                    articlesRequest.limit ?: 20
                )
            )
    }
}