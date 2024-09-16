package github.maxsplawski.realworld.config

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackages = ["github.maxsplawski.realworld.external"])
class MongoConfiguration {
}