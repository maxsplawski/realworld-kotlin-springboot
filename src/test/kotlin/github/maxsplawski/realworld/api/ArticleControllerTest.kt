package github.maxsplawski.realworld.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(ArticleController::class)
class ArticleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return hello world`() {
        mockMvc.get("/api/articles")
            .andExpect { status { isOk() } }
            .andExpect { content { string("Hello World") } }
    }
}