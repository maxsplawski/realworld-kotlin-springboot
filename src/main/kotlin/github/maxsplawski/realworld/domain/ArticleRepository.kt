package github.maxsplawski.realworld.domain

interface ArticleRepository {

    fun findAll(articlesFilter: ArticlesFilter): List<Article>

    fun findById(id: ArticleId): Article?

    fun save(article: Article): Article
}