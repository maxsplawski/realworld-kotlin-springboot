package github.maxsplawski.realworld.domain

interface ArticleRepository {

    fun findById(id: Int): Article?
}