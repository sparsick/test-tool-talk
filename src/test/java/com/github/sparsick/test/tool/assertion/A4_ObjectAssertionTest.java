package com.github.sparsick.test.tool.assertion;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class A4_ObjectAssertionTest {

    @Test
    void hasField() {
        assertThat(new Hero("Superman", "Clark Kent")).hasFieldOrProperty("realName");
        assertThat(new Hero("Superman", "Clark Kent"))
                .hasFieldOrPropertyWithValue("realName", "Clark Kent")
                .hasFieldOrPropertyWithValue("name", "Superman");
    }

    @Test
    void hasNullField() {
        assertThat(new Hero(null, null)).hasAllNullFieldsOrProperties();
        //  	hasAllNullFieldsOrPropertiesExcept
        //  	hasNoNullFieldsOrProperties()
        //  	hasNoNullFieldsOrPropertiesExcept
    }

    @Test
    @Disabled
    void isEqualToComparingFieldByFieldSample() {
        assertThat(new Hero("Superman", "Clark Kent"))
                .isEqualToComparingFieldByField(new Hero("Batman", "Bruce Wayne"));
        //        isEqualToComparingFieldByFieldRecursively
        //  	  isEqualToComparingOnlyGivenFields
        //        isEqualToIgnoringGivenFields
        //  	  isEqualToIgnoringNullFields
    }


    @Test
    void fileSpecific() {
        assertThat(new File(("src/test/resources/testdata.csv"))).canRead().canWrite().exists();
        //  	doesNotExist
        //      hasBinaryContent
        //      hasContent
        //      hasSameContentAs
        //      hasDigest
        //      hasName
        //      hasParent
        //      isFile
        //      isDirectory
        //      usingCharset
    }

    @Test
    void UrlSpecific() throws MalformedURLException {
        assertThat(new URL("https://www.sandra-parsick.de")).hasNoPort();

        // hasProtocol
        // hasQuery
        // hasPath
        // negation
    }

    @Test
    void dateSpecific() {
        assertThat(LocalDate.now()).isToday();

        // isBetween
        // isAfter
    }


}
