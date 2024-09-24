package github.maxsplawski.realworld.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper =
        ObjectMapper().apply {
            enable(SerializationFeature.WRAP_ROOT_VALUE)
        }
}