package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticleDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ArticleFacadeTest {

    @Mock
    private lateinit var repository: ArticleRepository

    @InjectMocks
    private lateinit var facade: ArticleFacade

    private lateinit var existingArticle: Article

    @BeforeEach
    fun setUp() {
        existingArticle = Article(
            id = ArticleId("id"),
            title = "title",
            body = "body",
            description = "description",
        )
    }

    @Test
    fun `should get article`() {
        // given
        val expectedArticleDto = ArticleDto(
            id = "id",
            title = "title",
            body = "body",
            description = "description",
        )

        `when`(repository.findById(existingArticle.id)).thenReturn(existingArticle)

        // when
        val result = facade.getArticle(existingArticle.id)

        // then
        assertThat(result).isEqualTo(expectedArticleDto)
    }
}
