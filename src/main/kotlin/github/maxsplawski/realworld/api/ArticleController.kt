package github.maxsplawski.realworld.api

import github.maxsplawski.realworld.domain.ArticleFacade
import github.maxsplawski.realworld.domain.ArticleId
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/articles")
class ArticleController(private val facade: ArticleFacade) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getArticles(@ModelAttribute articlesRequest: ArticlesRequest): ResponseEntity<Map<String, List<ArticleDto>>> {
        val articles = facade.getArticles(articlesRequest)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapOf("articles" to articles))
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getArticle(@PathVariable id: ArticleId): ResponseEntity<Map<String, ArticleDto>> {
        val article = facade.getArticle(id)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapOf("article" to article))
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createArticle(@RequestBody createArticleRequest: CreateArticleRequest): ResponseEntity<Map<String, ArticleDto>> {
        val article = facade.createArticle(createArticleRequest)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(mapOf("article" to article))
    }

    @PutMapping(
        "/{id}",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateArticle(
        @PathVariable id: ArticleId,
        @RequestBody updateArticleRequest: UpdateArticleRequest
    ): ResponseEntity<Map<String, ArticleDto>> {
        val article = facade.updateArticle(id, updateArticleRequest)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapOf("article" to article))
    }

    @DeleteMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteArticle(@PathVariable id: ArticleId): ResponseEntity<Void> {
        facade.deleteArticle(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
