package com.github.sparsick.test.tool.http.client;


import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import groovy.text.SimpleTemplateEngine;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest
class StarWarsClientWiremockTest {

    private static String starship1TestDataTemplate;
    private static String starship2TestDataTemplate;


    private StarWarsClient clientUnderTest;
    private String testData;
    private String testData2;


    @BeforeAll
    public static void testDataSetup() throws IOException {
        try (InputStream inputStream = new ClassPathResource("starwars-testdata/starship1.json").getInputStream()) {
            starship1TestDataTemplate = IOUtils.toString(inputStream, Charset.defaultCharset().toString());
        }

        try (InputStream inputStream = new ClassPathResource("starwars-testdata/starship2.json").getInputStream()) {
            starship2TestDataTemplate = IOUtils.toString(inputStream, Charset.defaultCharset().toString());
        }
    }

    @BeforeEach
    public void setUp(WireMockRuntimeInfo wiremock) throws Exception {
        clientUnderTest = new StarWarsClient("http://localhost:" + wiremock.getHttpPort());
        Map<String, String> binding = new HashMap<>();
        binding.put("baseUrl","localhost:" + wiremock.getHttpPort());
        testData = new SimpleTemplateEngine().createTemplate(starship1TestDataTemplate).make(binding).toString();
        testData2 = new SimpleTemplateEngine().createTemplate(starship2TestDataTemplate).make(binding).toString();
    }


    @Test
    void findAllStarships() {
        stubFor(get(urlEqualTo("/api/starships"))
                                .willReturn(aResponse().withBody(testData)));
        stubFor(get(urlEqualTo("/api/starships2"))
                                .willReturn(aResponse().withBody(testData2)));

        List<Starship> allStarships = clientUnderTest.findAllStarships();

        assertThat(allStarships).hasSize(11);
    }


    @Test
    void verifyFindAllStarshipsRequest(){
        stubFor(get(urlEqualTo("/api/starships"))
                .willReturn(aResponse().withBody(testData)));
        stubFor(get(urlEqualTo("/api/starships2"))
                .willReturn(aResponse().withBody(testData2)));

        List<Starship> allStarships = clientUnderTest.findAllStarships();

        assertThat(allStarships).hasSize(11);

        verify(1, getRequestedFor(urlEqualTo("/api/starships")));
        verify(1, getRequestedFor(urlEqualTo("/api/starships2")));
    }

}