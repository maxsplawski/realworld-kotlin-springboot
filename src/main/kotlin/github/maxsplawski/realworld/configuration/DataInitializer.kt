package github.maxsplawski.realworld.configuration

import github.maxsplawski.realworld.domain.ArticleRepository
import github.maxsplawski.realworld.external.ArticleEntity
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val articleRepository: ArticleRepository
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
        articleRepository.saveAll(articles)
        logger.info("Initialization complete")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(DataInitializer::class.java)
    }
}