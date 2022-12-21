package com.github.sparsick.test.tool.database;

import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class DbMigrationJUnit4Test {
    
    @Rule
    public PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();
    
    @Test
    public void testDbMigrationFromTheScratch(){
        Flyway flyway = Flyway.configure().dataSource(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword()).load();


        flyway.migrate();
    }
    
}