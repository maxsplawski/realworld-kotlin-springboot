package github.maxsplawski.realworld.domain.article

import github.maxsplawski.realworld.api.ArticleDto
import github.maxsplawski.realworld.api.ArticlesRequest
import github.maxsplawski.realworld.api.CreateArticleRequest
import github.maxsplawski.realworld.api.UpdateArticleRequest
import github.maxsplawski.realworld.domain.ArticleNotFoundException
import org.springframework.stereotype.Component

@Component
class ArticleService(private val articleRepository: ArticleRepository) {

    fun getArticles(articlesRequest: ArticlesRequest) =
        articleRepository
            .findAll(ArticlesFilter.from(articlesRequest))
            .map { it.toDto() }

    fun getArticle(id: ArticleId) =
        articleRepository.findById(id)?.toDto()
            ?: throw ArticleNotFoundException("Article with id: '${id.value}' not found")

    fun createArticle(createArticleRequest: CreateArticleRequest): ArticleDto {
        val article = Article.from(createArticleRequest)
        return articleRepository
            .save(article)
            .toDto()
    }

    fun updateArticle(id: ArticleId, updateArticleRequest: UpdateArticleRequest): ArticleDto {
        val articleUpdate = ArticleUpdate.from(updateArticleRequest)
        return articleRepository
            .update(id, articleUpdate)
            ?.toDto()
            ?: throw ArticleNotFoundException("Article with id: '${id.value}' not found")
    }

    fun deleteArticle(id: ArticleId) =
        articleRepository.delete(id)
}
