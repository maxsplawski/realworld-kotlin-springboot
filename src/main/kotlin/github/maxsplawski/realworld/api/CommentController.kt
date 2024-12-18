package github.maxsplawski.realworld.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/articles")
class CommentController {

    @PostMapping(
        "/{id}/comments",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createComment(@PathVariable articleId: String, @RequestBody createCommentRequest: CreateCommentRequest) {
        TODO("Not yet implemented")
    }
}