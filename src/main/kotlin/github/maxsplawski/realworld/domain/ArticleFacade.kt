package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import github.maxsplawski.realworld.api.ArticlesRequest
import org.springframework.stereotype.Component

@Component
class ArticleFacade(private val articleRepository: ArticleRepository) {

    fun getArticles(articlesRequest: ArticlesRequest): List<ArticleDto> {
        return articleRepository
            .findAll(ArticlesFilter.from(articlesRequest))
            .map { it.toDto() }
    }

    fun getArticle(id: ArticleId): ArticleDto? {
        return articleRepository.findById(id)?.toDto()
    }

    fun createArticle(articleDto: ArticleDto): ArticleDto {
        val article = Article.from(articleDto)
        return articleRepository.save(article).toDto()
    }

    fun updateArticle(): Nothing = TODO()

    fun deleteArticle(id: ArticleId) =
        articleRepository.delete(id)
}