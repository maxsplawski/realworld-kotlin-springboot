package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleId
import github.maxsplawski.realworld.domain.ArticleRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

@Repository
class ArticleRepositoryImpl(private val mongoOperations: MongoOperations) : ArticleRepository {

    override fun findById(id: ArticleId): Article? =
        mongoOperations.findById(id, ArticleEntity::class.java)?.toDomain()

    override fun save(article: Article): Article =
        mongoOperations.save(article)
}