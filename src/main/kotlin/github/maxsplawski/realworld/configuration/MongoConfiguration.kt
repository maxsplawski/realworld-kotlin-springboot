package github.maxsplawski.realworld.configuration

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackages = ["github.maxsplawski.realworld.external"])
class MongoConfiguration {
}