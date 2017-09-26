package br.com.app.controller;

import static io.restassured.RestAssured.when;
import static java.lang.String.format;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerControllerE2ETest {

    @LocalServerPort
    private int port;

    @Test
    public void customersSouldReturnResult () throws Exception {
        when().get(format("http://localhost:%d/customers", this.port))
                .then()
                .statusCode(is(200))
                .body("content", hasSize(3))
                .body("totalElements", is(3));
    }
}