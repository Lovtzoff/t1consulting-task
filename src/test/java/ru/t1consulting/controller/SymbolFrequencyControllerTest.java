package ru.t1consulting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.t1consulting.model.SymbolFrequency;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SymbolFrequencyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getSymbolFrequencyTest() {
        String inputString = "aaaaabcccc";
        List<SymbolFrequency> expectedList = Arrays.asList(
                SymbolFrequency.builder()
                        .symbol('a')
                        .frequency(5)
                        .build(),
                SymbolFrequency.builder()
                        .symbol('c')
                        .frequency(4)
                        .build(),
                SymbolFrequency.builder()
                        .symbol('b')
                        .frequency(1)
                        .build());

        // Отправка GET-запроса с параметром inputString
        ResponseEntity<List<SymbolFrequency>> response = restTemplate.exchange(
                "/symbol-frequency?inputString={inputString}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SymbolFrequency>>() {
                },
                inputString);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expectedList));
    }
}