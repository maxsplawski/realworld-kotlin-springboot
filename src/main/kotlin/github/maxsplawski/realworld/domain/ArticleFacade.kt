package github.maxsplawski.realworld.domain

import org.springframework.stereotype.Service

@Service
class ArticleFacade(private val articleRepository: ArticleRepository) {

    fun getArticle(id: ArticleId): Article? {
        return articleRepository.findById(id)
    }
}