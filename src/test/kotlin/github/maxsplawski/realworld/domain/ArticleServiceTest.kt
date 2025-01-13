package github.maxsplawski.realworld.domain

import github.maxsplawski.realworld.api.ArticlesRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ArticleServiceTest {

    @Mock
    private lateinit var repository: ArticleRepository

    @InjectMocks
    private lateinit var service: ArticleService

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
    fun `should return list of articles mapped to dtos`() {
        // given
        val request = ArticlesRequest()
        val articles = listOf(existingArticle, existingArticle.copy(ArticleId("id2")))
        val articleDtos = articles.map { it.toDto() }

        `when`(repository.findAll(ArticlesFilter.from(request))).thenReturn(articles)

        // when
        val result = service.getArticles(request)

        // then
        assertThat(result).hasSize(2)
        assertThat(result).isEqualTo(articleDtos)
    }

    @Test
    fun `should return article mapped to dto when it exists`() {
        // given
        val articleDto = existingArticle.toDto()

        `when`(repository.findById(existingArticle.id)).thenReturn(existingArticle)

        // when
        val result = service.getArticle(existingArticle.id)

        // then
        assertThat(result).isEqualTo(articleDto)
    }

    @Test
    fun `should throw exception when article does not exist`() {
        // given
        val id = ArticleId("id")
        `when`(repository.findById(id)).thenReturn(null)

        // expect
        val exception = assertThrows<ArticleNotFoundException> {
            service.getArticle(id)
        }
        assertThat(exception.message).isEqualTo("Article with id: 'id' not found")
    }

    @Test
    fun `should save and return article`() {
        TODO()
    }

    @Test
    fun `should update and return article`() {
        TODO()
    }
}
