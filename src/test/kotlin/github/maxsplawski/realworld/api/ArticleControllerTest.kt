package github.maxsplawski.realworld.api

import github.maxsplawski.realworld.domain.Article
import github.maxsplawski.realworld.domain.ArticleFacade
import github.maxsplawski.realworld.domain.ArticleId
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(ArticleController::class)
class ArticleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var facade: ArticleFacade

    @Test
    fun `should return hello world`() {
        val article = Article(
            id = ArticleId("123"),
            title = "test",
            body = "testBody",
            description = "testDescription",
        )

        `when`(facade.getArticle(ArticleId("123"))).thenReturn(article)

        mockMvc.get("/api/articles/{id}", article.id.value)
            .andExpect { status { isOk() } }
            .andExpect { jsonPath("$.id") { value(article.id.value) } }
            .andExpect { jsonPath("$.title") { value(article.title) } }
            .andExpect { jsonPath("$.body") { value(article.body) } }
            .andExpect { jsonPath("$.description") { value(article.description) } }
    }
}