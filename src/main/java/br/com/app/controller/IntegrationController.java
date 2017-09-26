package br.com.app.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import br.com.app.service.IntegrationService;
import br.com.app.domain.vo.WeatherInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IntegrationController {

    private final IntegrationService service;

    @GetMapping(path = "/greetings", produces = TEXT_PLAIN_VALUE)
    public String greetings (final String name) {
        return this.service.makeGreetings(name);
    }

    @GetMapping("/weather")
    public WeatherInfo weather (final String city) {
        return this.service.getWeatherInfo(city);
    }
}
