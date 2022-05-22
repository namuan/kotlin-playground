package com.github.namuan.playground.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController {
    @GetMapping("/weather")
    fun report(): Map<String, Double> {
        return mapOf("London" to 23.0)
    }
}
