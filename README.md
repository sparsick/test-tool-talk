# test-tool-talk

![Build Status](https://github.com/sparsick/test-tool-talk/workflows/MavenBuild/badge.svg)

You can find here the slides and the sample code of my talk "Ich packe meinen Testtoolkoffer und nehme mit ..." that I presented on JUG Ostfalen at 26th September 2024

The code samples are tested with Java 21 and Groovy 4.x, embedded in a Spring Boot 3.1.x skeleton.
Following test libraries are used:
- JUnit 5.9.3 including JUnit 4 (JUnit Jupiter Vintage)
- Spock 2.3
- DataFaker 2.0.1
- AssertJ 3.24.2
- AssertJ-DB 2.0.2
- EqualsVerifier 3.14.3
- To String Verifier 1.4.8
- MockServer 5.15.0
- Wiremock 3.0.0-beta-10
- Greenmail 2.0.0
- Testcontainers 1.18.3
- REST assured 
- Awaitility 4.2.0

## Tests should run under specific conditions
The test class `ConditionalTestExecutionTest` shows how tests can be configured to run only if a specific condition is enabled.

## Parametrized Tests
All classes in the package `com.github.sparsick.test.tool.parametrizedtests` show how to write parametrized tests with JUnit4, JUnit5 and Spock.

## Test data
The test class `PersonTestDataTest` demonstrates JavaFaker and how to use ObjectMother (implementation is shown in `PersonTestData`) and TestdataBuilder (implementation is shown in `PersonTestDataBuilder`) pattern.

## Verifing equals and hashCode contract and toString
The test class `PersonTest` demonstrates how to verify the implementation of equals(), hashcode() and toString() methods with EqualsVerifier and ToStringVerifier.

## Assertions
Test package `com.github.sparsick.test.tool.assertion` demonstrates well readable assertions.

## Test with Concurrency
Test package `com.github.sparsick.test.tool.concurrency` demonstrates how awaitility can help handling concurrency in tests.

## Simulate Infrastructure in Software Tests (Integrationtests)

### Tests against own REST API
The test class `StarWarsMovieControllerITest` shows how to test own REST API with Spring MVC and REST assured.

### Mock REST dependencies
The test classes `StarWarsClientMockserverTest`, `StarWarsClientWiremockTest` and `StarWarsClientMockserverGroovyTest` show how to mock dependencies to a REST API with MockServer or Wiremock.

### Testing interaction with E-Mails
The test class `MailClientTest` shows how to test interaction with e-mails (currently only sending) with Greenmail

### Testing interaction with Database
The test class `PersonRepositoryJUnit4/5/SpockTest`shows how to test the repository logic including the database that is used in production with Testcontainers.
Test class `DBMigrationJUnit4/5Test` shows how to test the database migration script inside my Maven build.
The test `PersonRepositoryJdbcUrlTestContainerTest` shows how to integate testcontainer only via a JDBC URL.
