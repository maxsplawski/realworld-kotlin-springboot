package github.maxsplawski.realworld.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles")
class ArticleController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloWorld() = "Hello World!"
}