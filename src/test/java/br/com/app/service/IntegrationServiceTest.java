package br.com.app.service;

import static org.junit.Assert.assertEquals;

import br.com.app.config.AppProperties;
import br.com.app.service.client.WeatherClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationServiceTest {

    @Mock
    private AppProperties properties;

    @Mock
    private WeatherClient weatherClient;

    private IntegrationService subject;

    @Before
    public void setUp () throws Exception {
        this.subject = new IntegrationService(this.properties, this.weatherClient);
    }

    @Test
    public void makeGreetingsShouldReturnVisitorMessage () throws Exception {
        final String greetings = this.subject.makeGreetings(null);
        assertEquals("Hello visitor!", greetings);
    }

    @Test
    public void makeGreetingsShouldReturnUserMessage () throws Exception {
        final String greetings = this.subject.makeGreetings("User");
        assertEquals("Hello User!", greetings);
    }
}