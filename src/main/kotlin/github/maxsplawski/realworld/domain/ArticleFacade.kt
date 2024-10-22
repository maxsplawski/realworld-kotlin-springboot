package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import github.maxsplawski.realworld.api.ArticlesRequest
import org.springframework.stereotype.Component

@Component
class ArticleFacade(private val articleRepository: ArticleRepository) {

    fun getArticles(articlesRequest: ArticlesRequest) =
        articleRepository
            .findAll(ArticlesFilter.from(articlesRequest))
            .map { it.toDto() }

    fun getArticle(id: ArticleId) =
        articleRepository.findById(id)?.toDto()
            ?: throw ArticleNotFoundException("Article with id: '$id' not found")

    fun createArticle(articleDto: ArticleDto): ArticleDto {
        val article = Article.from(articleDto)
        return articleRepository
            .save(article)
            .toDto()
    }

    fun updateArticle(articleDto: ArticleDto): ArticleDto {
        val article = Article.from(articleDto)
        return articleRepository
            .update(article)
            .toDto()
    }

    fun deleteArticle(id: ArticleId) =
        articleRepository.delete(id)
}
