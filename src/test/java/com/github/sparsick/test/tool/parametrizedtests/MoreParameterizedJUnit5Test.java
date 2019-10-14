package com.github.sparsick.test.tool.parametrizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoreParameterizedJUnit5Test {

    // Source of Arguments

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void singleLetter(String candidate) {
        assertTrue(isSingleLetter(candidate));
    }

    private boolean isSingleLetter(String candidate) {
        return candidate.length() == 1;
    }

    // type for value sources:
    //    short
    //    byte
    //    int
    //    long
    //    float
    //    double
    //    char
    //    java.lang.String
    //    java.lang.Class


    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void timeUnit(TimeUnit timeUnit) {
        assertThat(timeUnit).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2",
                 "'baz, qux', 3" })
    // @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }

//    @NullSource: provides a single null argument to the annotated @ParameterizedTest method.
//    @NullSource cannot be used for a parameter that has a primitive type.
//
//    @EmptySource: provides a single empty argument to the annotated @ParameterizedTest method for parameters of the following types: java.lang.String, java.util.List, java.util.Set, java.util.Map, primitive arrays (e.g., int[], char[][], etc.), object arrays (e.g.,String[], Integer[][], etc.).
//    Subtypes of the supported types are not supported.
//
//    @NullAndEmptySource: a composed annotation that combines the functionality of @NullSource and @EmptySource.




}
