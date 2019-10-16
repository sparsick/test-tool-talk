package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assumptions.assumeThat;

class A7_AssumptionTest {

    @Test
    void assume(){
        assumeThat("Bonn").isEqualTo("Bonn");
    }

    @Test
    void assumeMoreComplex(){
        assumeThat(new File("/starwars-testdata/star-wars-logo.png"))
                .isFile()
                .exists();
        assumeThat(List.of("Hello", "World"))
                .hasSize(2)
                .contains("Hello");
    }
}
