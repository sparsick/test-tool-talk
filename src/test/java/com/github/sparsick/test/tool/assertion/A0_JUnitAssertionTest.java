package com.github.sparsick.test.tool.assertion;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class A0_JUnitAssertionTest {

    @Test
    void builtInAssertion() {
        Hero hero = new Hero("Batman", "Bruce Wayne");

        assertEquals(hero.getName(), "Batman");
        assertEquals(hero.getRealName(), "Bruce Wayne");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("John","John"),
                () -> assertEquals("Doe", "Doe"),
                () -> assertThat(Lists.list("foo")).isNotEmpty()
        );
    }


}
