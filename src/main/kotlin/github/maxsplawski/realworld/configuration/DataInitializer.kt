package github.maxsplawski.realworld.configuration

import github.maxsplawski.realworld.external.ArticleEntity
import jakarta.annotation.PreDestroy
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val mongoTemplate: MongoTemplate,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val articles = listOf(
            ArticleEntity(
                ObjectId.get(),
                "article1",
                "article1 description",
                "article 1 body",
            ),
            ArticleEntity(
                ObjectId.get(),
                "article2",
                "article2 description",
                "article 2 body",
            ),
            ArticleEntity(
                ObjectId.get(),
                "article3",
                "article3 description",
                "article 3 body",
            ),
            ArticleEntity(
                ObjectId.get(),
                "article4",
                "article4 description",
                "article 4 body",
            ),
        )

        logger.info("Initializing data: $articles.")
        mongoTemplate.insertAll(articles)
        logger.info("Initialization complete.")
    }

    @PreDestroy
    fun clearData() {
        with(mongoTemplate.db) {
            getCollection("articles").drop()
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(DataInitializer::class.java)
    }
}