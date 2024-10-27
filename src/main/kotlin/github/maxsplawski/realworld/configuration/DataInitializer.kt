package github.maxsplawski.realworld.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import github.maxsplawski.realworld.external.ArticleEntity
import jakarta.annotation.PreDestroy
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ClassPathResource
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component
import kotlin.time.measureTime

@Component
@Profile("dev")
class DataInitializer(
    private val objectMapper: ObjectMapper,
    private val mongoTemplate: MongoTemplate,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        logger.info("Initializing data")
        var articles: List<ArticleEntity>
        val elapsedTime = measureTime {
            val resource = ClassPathResource("json/articles.json")
            articles = objectMapper.readValue(resource.inputStream, Array<ArticleEntity>::class.java)
                .toList()
            mongoTemplate.insertAll(articles)
        }
        logger.info("Initialized data: $articles in ${elapsedTime.inWholeMilliseconds} ms")
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
