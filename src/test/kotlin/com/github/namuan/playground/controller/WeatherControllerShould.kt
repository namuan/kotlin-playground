package com.github.namuan.playground.controller

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import org.springframework.http.ResponseEntity
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.net.URI

@Extensions(
    ExtendWith(SpringExtension::class)
)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@TestPropertySource("classpath:application-test.properties")
class WeatherControllerShould {

    val restTemplate: RestTemplate = RestTemplate()

    @Test
    fun reportWeather() {
        val response: ResponseEntity<Map<*, *>> = restTemplate.getForEntity(
            URI.create("http://localhost:8090/weather")
        )

        assertThat(response.body!!, hasEntry("London", 23.0))
    }
}
