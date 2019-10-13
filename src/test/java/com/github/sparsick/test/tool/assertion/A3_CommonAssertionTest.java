package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class A3_CommonAssertionTest {

    @Test
    void instanceOf(){
        assertThat(new Hero("Superman" , "Clark Kent")).isInstanceOf(Hero.class);
        // isInstanceOfAny
    }

    @Test
    void isInSample(){
        assertThat("superman").isIn("superman", "batman");
    }

    // isNull

    // negation




}
