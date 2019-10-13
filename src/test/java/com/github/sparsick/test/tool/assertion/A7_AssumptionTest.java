package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assumptions.assumeThat;

class A7_AssumptionTest {

    @Test
    void assume(){
        assumeThat("Bonn").isEqualTo("Bonn");
    }
}
