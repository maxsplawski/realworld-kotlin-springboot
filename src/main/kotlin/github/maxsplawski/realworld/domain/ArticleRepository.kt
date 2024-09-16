package github.maxsplawski.realworld.domain

interface ArticleRepository {

    fun findById(id: ArticleId): Article?
}