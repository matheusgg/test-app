package br.com.app.domain.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherInfo {

    private List<Info> list;

    @Data
    public static class Info {

        private MainInfo main;
    }

    @Data
    public static class MainInfo {

        private float temp;

        @JsonProperty("temp_min")
        private float min;

        @JsonProperty("temp_max")
        private float max;

        private float humidity;
    }
}
