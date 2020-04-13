# test-tool-talk
You can find here the slides and the sample code of my talk "Ich packe meinen Testtoolkoffer und nehme mit ... - Testwerkzeuge für den Entwickleralltag" that I presented on Dev@home remote at 14th April 2020.

The code samples are tested with Java 11, embedded in a Spring Boot 2.1.8 skeleton.
Following test libraries are used:
- JUnit 5.5.2 including JUnit 4 (JUnit Jupiter Vintage)
- Spock 1.3
- JavaFaker 1.0.1
- AssertJ 3.13.2
- EqualsVerifier 3.1.10
- To String Verifier 1.4.6
- MockServer 5.10
- Wiremock 2.26.3
- Greenmail 1.5.11
- Testcontainers 1.13.0
- REST assured 4.1.2

## Tests should run under specific conditions
The test class `ConditionalTestExecutionTest` shows how tests can be configured to run only if a specific condition is enabled.

## Parametrized Tests
All classes in the package `com.github.sparsick.test.tool.parametrizedtests` show how to write parametrized tests with JUnit4, JUnit5 and Spock.

## Test data
The test class `PersonTestDataTest` demonstrates JavaFaker and how to use ObjectMother (implementation is shown in `PersonTestData`) and TestdataBuilder (implementation is shown in `PersonTestDataBuilder`) pattern.

## Verifing equals and hashCode contract and toString
The test class `PersonTest` demonstrates how to verify the implementation of equals(), hashcode() and toString() methods with EqualsVerifier and ToStringVerifier.

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
