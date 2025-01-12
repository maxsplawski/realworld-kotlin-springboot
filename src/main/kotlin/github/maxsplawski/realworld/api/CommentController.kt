package github.maxsplawski.realworld.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController("/api/articles")
class CommentController {

    @GetMapping("/{slug}/comments", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getComment(@PathVariable slug: String) {
        TODO("Not yet implemented")
    }

    @PostMapping(
        "/{slug}/comments",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createComment(@PathVariable slug: String, @RequestBody createCommentRequest: CreateCommentRequest) {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{slug}/comments/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteComment(@PathVariable slug: String, @PathVariable id: String) {
        TODO("Not yet implemented")
    }
}