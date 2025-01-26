package github.maxsplawski.realworld.domain.comment


import github.maxsplawski.realworld.domain.article.ArticleService

class CommentService(private val articleService: ArticleService) {

    fun getArticleComments(slug: String): Nothing = TODO("Not yet implemented")
}