package github.maxsplawski.realworld.api

import github.maxsplawski.realworld.domain.ArticleFacade
import github.maxsplawski.realworld.domain.ArticleId
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/articles")
class ArticleController(private val facade: ArticleFacade) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getArticles(@ModelAttribute articlesRequest: ArticlesRequest) =
        facade.getArticles(articlesRequest)


    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getArticle(@PathVariable id: ArticleId) =
        facade.getArticle(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createArticle(@RequestBody articleDto: ArticleDto): ResponseEntity<ArticleDto> {
        val article = facade.createArticle(articleDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(article)
    }
}