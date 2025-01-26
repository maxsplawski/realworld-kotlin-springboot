package github.maxsplawski.realworld.domain.article

interface ArticleRepository {

    fun findAll(articlesFilter: ArticlesFilter): List<Article>

    fun findById(id: ArticleId): Article?

    fun findBySlug(slug: String): Article?

    fun save(article: Article): Article

    fun saveAll(articles: List<Article>)

    fun update(id: ArticleId, articleUpdate: ArticleUpdate): Article?

    fun delete(id: ArticleId): Unit
}