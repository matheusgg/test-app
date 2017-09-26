package br.com.app.service.client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static java.nio.file.Files.readAllBytes;
import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.nio.file.Paths;

import br.com.app.domain.vo.WeatherInfo;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherClientIntegrationTest {

    @Autowired
    private WeatherClient subject;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8189);

    @Before
    public void setUp () throws Exception {
        this.wireMockRule.stubFor(get(urlPathEqualTo("/forecast"))
                .willReturn(aResponse()
                        .withBody(readAllBytes(Paths.get("./src/test/resources/weather.json")))
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .withStatus(200)));

    }

    @Test
    public void forecast () throws Exception {
        final WeatherInfo weatherInfo = this.subject.forecast("Sao Paulo", EMPTY);
        assertNotNull(weatherInfo);
        assertNotNull(weatherInfo.getList());
        assertFalse(weatherInfo.getList().isEmpty());
    }
}