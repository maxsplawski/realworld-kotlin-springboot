package github.maxsplawski.realworld.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController("/api/articles")
class CommentController {

    @GetMapping("/{id}/comments", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getComment(@PathVariable id: String) {
        TODO("Not yet implemented")
    }

    @PostMapping(
        "/{id}/comments",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createComment(@PathVariable id: String, @RequestBody createCommentRequest: CreateCommentRequest) {
        TODO("Not yet implemented")
    }
}