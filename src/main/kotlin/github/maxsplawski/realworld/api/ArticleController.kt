package github.maxsplawski.realworld.api

import github.maxsplawski.realworld.domain.ArticleFacade
import github.maxsplawski.realworld.domain.ArticleId
import github.maxsplawski.realworld.domain.toDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/articles")
class ArticleController(private val facade: ArticleFacade) {

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getArticle(@PathVariable id: ArticleId) =
        facade.getArticle(id)?.toDto() ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}