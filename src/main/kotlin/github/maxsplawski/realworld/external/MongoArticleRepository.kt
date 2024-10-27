package github.maxsplawski.realworld.external

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleId
import github.maxsplawski.realworld.domain.ArticleRepository
import github.maxsplawski.realworld.domain.ArticleUpdate
import github.maxsplawski.realworld.domain.ArticlesFilter
import github.maxsplawski.realworld.domain.toObjectId
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class MongoArticleRepository(private val mongoOperations: MongoOperations) : ArticleRepository {

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

    override fun findById(id: ArticleId) =
        mongoOperations.findById(id.toObjectId(), ArticleEntity::class.java)?.toDomain()

    override fun save(article: Article) =
        mongoOperations.save(ArticleEntity.from(article)).toDomain()

    override fun saveAll(articles: List<Article>) {
        mongoOperations.insertAll(articles.map { ArticleEntity.from(it) })
    }

    override fun update(id: ArticleId, articleUpdate: ArticleUpdate): Article? {
        val query = Query(Criteria.where("_id").`is`(id.toObjectId()))
        val update = Update()
        val options = FindAndModifyOptions.options().returnNew(true)

        with(articleUpdate) {
            title?.let {
                update.set("title", it)
            }
            description?.let {
                update.set("description", it)
            }
            body?.let {
                update.set("body", it)
            }
        }

        return mongoOperations
            .findAndModify(query, update, options, ArticleEntity::class.java)
            ?.toDomain()
    }

    override fun delete(id: ArticleId) {
        val query = Query(Criteria.where("_id").`is`(id.toObjectId()))
        mongoOperations.remove(query, ArticleEntity::class.java)
    }
}
