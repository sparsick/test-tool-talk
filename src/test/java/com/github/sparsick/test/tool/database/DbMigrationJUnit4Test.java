package com.github.sparsick.test.tool.database;

import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static com.github.sparsick.test.tool.DatabaseProvider.*;

public class DbMigrationJUnit4Test {
    
    @Rule
    public PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer(POSTGRES.getDockerImageName());
    
    @Test
    public void testDbMigrationFromTheScratch(){
        Flyway flyway = Flyway.configure().dataSource(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword()).load();


        flyway.migrate();
    }
    
}