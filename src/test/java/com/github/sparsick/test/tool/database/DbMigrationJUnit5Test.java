package com.github.sparsick.test.tool.database;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.github.sparsick.test.tool.DatabaseProvider.POSTGRES;

@Testcontainers
class DbMigrationJUnit5Test {
    
    @Container
    public PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer(POSTGRES.getDockerImageName());


    @Test
    void testDbMigrationFromTheScratch(){
        Flyway flyway = Flyway.configure().dataSource(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword()).load();
        
        flyway.migrate();
    }
}