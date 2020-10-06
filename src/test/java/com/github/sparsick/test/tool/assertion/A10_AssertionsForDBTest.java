package com.github.sparsick.test.tool.assertion;


import com.github.sparsick.test.tool.database.Person;
import com.github.sparsick.test.tool.database.PersonRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.api.Assertions.assertThat;

@Testcontainers
class A10_AssertionsForDBTest {

    @Container
    private PostgreSQLContainer postgres = new PostgreSQLContainer();

    private PersonRepository repositoryUnderTest;
    private HikariDataSource dataSource;

    @BeforeEach
    void setup(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(postgres.getJdbcUrl());
        hikariConfig.setUsername(postgres.getUsername());
        hikariConfig.setPassword(postgres.getPassword());

        dataSource = new HikariDataSource(hikariConfig);
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();

        repositoryUnderTest = new PersonRepository(dataSource);
    }

    @Test
    void savePerson() {
        Person person = new Person();
        person.setFirstName("Matt");
        person.setLastName("Clark");
        person.setJobTitle("actor");

        repositoryUnderTest.save(person);

        var personTable = new Table(dataSource, "person");
        assertThat(personTable)
                .column("first_name").containsValues("Matt")
                .column("last_name").containsValues("Clark")
                .column("job_title").containsValues("actor");
    }
}