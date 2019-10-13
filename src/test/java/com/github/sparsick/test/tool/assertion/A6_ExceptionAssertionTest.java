package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

class A6_ExceptionAssertionTest {

    @Test
    void bddStyle(){
        // GIVEN
        String[] names = { "Pier ", "Pol", "Jak" };
        // WHEN
        Throwable thrown = catchThrowable(() -> System.out.println(names[9]));
        // THEN
        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("9");
    }

    @Test
    void assertThatThrownByExample(){
        assertThatThrownBy(() -> { throw new Exception("boom!"); }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom")
                .hasMessage("boom!");
    }

    @Test
    void assertThatExceptionOfTypeExample(){
        assertThatExceptionOfType(IOException.class).isThrownBy(() -> { throw new IOException("boom!"); })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }
    //This later syntax has been enriched for common exceptions :
    //    assertThatNullPointerException
    //    assertThatIllegalArgumentException
    //    assertThatIllegalStateException
    //    assertThatIOException

    @Test
    void assertThatNoExceptionIsThrown(){
        assertThatCode(() -> {
            // code that should NOT throw an exception
        }).doesNotThrowAnyException();
    }

}
