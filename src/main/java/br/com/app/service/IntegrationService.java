package br.com.app.service;

import br.com.app.config.AppProperties;
import br.com.app.domain.vo.WeatherInfo;
import br.com.app.service.client.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntegrationService {

    private final AppProperties properties;

    private final WeatherClient weatherClient;

    public String makeGreetings (final String name) {
        final StringBuilder builder = new StringBuilder("Hello ");
        if (name == null) {
            builder.append("visitor");
        } else {
            builder.append(name);
        }
        return builder.append("!").toString();
    }

    public WeatherInfo getWeatherInfo (final String city) {
        return this.weatherClient.forecast(city, this.properties.getAppId());
    }
}
