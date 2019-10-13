package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class A1_BasicAssertionTest {


    @Test
    void basic() {
        assertThat("The Lord of the Rings").isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");
    }

    // show support types


}
