package br.com.app.service.client;

import br.com.app.domain.vo.WeatherInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherClient", url = "${br.com.app.weather-service-url}")
public interface WeatherClient {

    @GetMapping("/forecast")
    WeatherInfo forecast (@RequestParam("q") String city, @RequestParam("appid") String appId);
}
