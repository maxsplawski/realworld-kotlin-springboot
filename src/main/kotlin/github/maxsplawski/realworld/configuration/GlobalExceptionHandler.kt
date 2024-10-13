package github.maxsplawski.realworld.configuration

import github.maxsplawski.realworld.domain.ArticleNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException::class)
    fun handleArticleNotFoundException(ex: ArticleNotFoundException) =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.message)
}