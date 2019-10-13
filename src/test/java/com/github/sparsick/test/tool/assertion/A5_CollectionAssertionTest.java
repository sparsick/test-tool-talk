package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class A5_CollectionAssertionTest {

    @Test
    void basic(){
        List<String> heros = List.of("Batman", "Superman");

        assertThat(heros)
                .hasSize(2)
                .contains("Batman")
                .containsExactly("Batman", "Superman")
                .containsAnyOf("Batman", "Superman", "Wonder woman");

        // containsNull
        // negotation
    }

    @Test
    void extractionSample(){
        List<Hero> heros = List.of(new Hero("Batman", "Bruce Wayne"), new Hero("Superman", "Clark Kent"));

        assertThat(heros)
                .extracting("realName")
                .contains("Bruce Wayne", "Clark Kent");
    }
}
