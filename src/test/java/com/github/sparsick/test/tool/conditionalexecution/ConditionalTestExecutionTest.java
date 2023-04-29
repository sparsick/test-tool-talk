package com.github.sparsick.test.tool.conditionalexecution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionalTestExecutionTest {

    //  Operating System Conditions

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinux(){
        System.out.println("This is Linux");
        assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindows(){
        System.out.println("This is Windows");
        assertTrue(true);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void testForLinuxAndWindows(){
        assertTrue(true);
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    void testNotForLinux(){
        assertTrue(true);
    }

    // Java Runtime Environment Conditions

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {
        assertTrue(true);
    }

    @Test
    @EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
    void onJava9Or10() {
        assertTrue(true);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void notOnJava8() {
        assertTrue(true);
    }


    // System Property Conditions

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        assertTrue(true);

    }

    @BeforeEach
    void setup(){
        System.setProperty("ci-server", "true");
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    @EnabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {
        assertTrue(true);

    }

    // Environment Variable Conditions
    // variable can be set in idea run configuration
    // ENV1=staging-server
    // ENV2=local.development

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV1", matches = "staging-server")
    void onlyOnStagingServer() {
        assertTrue(true);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV2", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        assertTrue(true);
    }


    // More Conditions
    // @EnabledIf or @DisabledIf annotation.
}
