package github.maxsplawski.realworld.api

import github.maxsplawski.realworld.domain.ArticleFacade
import org.junit.jupiter.api.Test
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(ArticleController::class)
class ArticleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var facade: ArticleFacade

    @Test
    fun `should return an article`() {
        // given
        val article = ArticleDto(
            id = "123",
            title = "test",
            body = "testBody",
            description = "testDescription",
        )

        // when
        `when`(facade.getArticle(any())).thenReturn(article)

        // then
        mockMvc.get("/api/articles/{id}", article.id)
            .andExpect { status { isOk() } }
            .andExpect { jsonPath("$.article.id") { value(article.id) } }
            .andExpect { jsonPath("$.article.title") { value(article.title) } }
            .andExpect { jsonPath("$.article.body") { value(article.body) } }
            .andExpect { jsonPath("$.article.description") { value(article.description) } }
    }

    @Test
    fun `should create an article`() {
        // given
        val article = ArticleDto(
            id = "123",
            title = "test",
            body = "testBody",
            description = "testDescription",
        )

        // when
        `when`(facade.createArticle(any())).thenReturn(article)

        // then
        mockMvc.post("/api/articles")
            .andExpect { status { isCreated() } }
            .andExpect { jsonPath("$.article.id") { value(article.id) } }
            .andExpect { jsonPath("$.article.title") { value(article.title) } }
            .andExpect { jsonPath("$.article.body") { value(article.body) } }
            .andExpect { jsonPath("$.article.description") { value(article.description) } }
    }

    @Test
    fun `should update an article`() {
        TODO()
    }
}
