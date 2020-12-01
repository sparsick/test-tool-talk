package com.github.sparsick.test.tool.concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

class ConcurrencyDemoTest {

    @Test
    void awaitilityDemo() {
        var demoUnderTest = new ConcurrencyDemo();
        demoUnderTest.addItem("Hello World");

        await().until(demoUnderTest::hasNewItem);
        assertThat(demoUnderTest.allItems()).contains("Hello World");
    }

}