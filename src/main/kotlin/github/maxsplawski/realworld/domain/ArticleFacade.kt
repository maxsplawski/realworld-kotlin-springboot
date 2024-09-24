package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import org.springframework.stereotype.Component

@Component
class ArticleFacade(private val articleRepository: ArticleRepository) {

    fun getArticle(id: ArticleId): ArticleDto? {
        return articleRepository.findById(id)?.toDto()
    }

    fun createArticle(articleDto: ArticleDto): ArticleDto {
        val article = Article.from(articleDto)
        return articleRepository.save(article).toDto()
    }
}