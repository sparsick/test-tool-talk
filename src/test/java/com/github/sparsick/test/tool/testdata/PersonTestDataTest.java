package com.github.sparsick.test.tool.testdata;

import com.github.javafaker.Faker;
import com.github.sparsick.test.tool.database.Person;
import org.junit.jupiter.api.Test;

class PersonTestDataTest {

    @Test
    void simpleFaker() {
        Faker dataFaker = new Faker();
        Person person = new Person();
        person.setFirstName(dataFaker.name().firstName());
        person.setLastName(dataFaker.name().lastName());
        person.setJobTitle(dataFaker.job().title());
    }

    @Test
    void objectMother(){
        Person personWithoutJobTitle = PersonTestData.newPersonWithoutJobTitle();
        Person fullPerson = PersonTestData.newPerson();
    }

    @Test
    void testDataBuilder(){
        Faker dataFaker = new Faker();
        PersonTestDataBuilder personBuilder = new PersonTestDataBuilder();
        personBuilder.withFirstName(dataFaker.name().firstName())
                .withLastName(dataFaker.name().lastName())
                .withJobTitle(dataFaker.job().title());
        Person person = personBuilder.build();
    }
}
