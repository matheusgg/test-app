package br.com.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("br.com.app")
public class AppProperties {

    private String appId;
}
