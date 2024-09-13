package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
class ArticleRepositoryImpl : ArticleRepository, MongoRepository<ArticleEntity, Int> {

    override fun findById(id: Int): Article? {
        TODO("Not yet implemented")
    }
}