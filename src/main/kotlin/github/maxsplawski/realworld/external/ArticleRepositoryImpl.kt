package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleId
import github.maxsplawski.realworld.domain.ArticleRepository
import github.maxsplawski.realworld.domain.ArticlesFilter
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class ArticleRepositoryImpl(private val mongoOperations: MongoOperations) : ArticleRepository {

    override fun findAll(articlesFilter: ArticlesFilter): List<Article> {
        val query = Query()

        with(articlesFilter) {
            favorited?.let {
                query.addCriteria(Criteria.where("favorited").`in`(it))
            }
            author?.let {
                query.addCriteria(Criteria.where("author").`is`(it))
            }
            tag?.let {
                query.addCriteria(Criteria.where("tags").`in`(it))
            }
            query.with(pageable)
        }

        return mongoOperations
            .find(query, ArticleEntity::class.java)
            .map { it.toDomain() }
    }

    override fun findById(id: ArticleId): Article? =
        mongoOperations.findById(id, ArticleEntity::class.java)?.toDomain()

    override fun save(article: Article): Article =
        mongoOperations.save(ArticleEntity.from(article)).toDomain()

    override fun saveAll(articles: List<Article>) {
        mongoOperations.insertAll(articles.map { ArticleEntity.from(it) })
    }

    override fun delete(id: ArticleId) {
        val query = Query(Criteria.where("_id").`is`(id.value))
        mongoOperations.remove(query, ArticleEntity::class.java)
    }
}
