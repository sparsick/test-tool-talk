package com.github.sparsick.test.tool.database;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void equalsContractVerySimple(){
        Person person1 = createPerson();
        Person person2 = createPerson();
        person2.setJobTitle("Consultant");

        assertThat(person1).isNotEqualTo(person2);
        assertThat(person1.hashCode()).isNotEqualTo(person2.hashCode());
    }

    @Test
    void equalsContractMuchBetter(){
        EqualsVerifier.forClass(Person.class)
                .suppress(Warning.NONFINAL_FIELDS).verify();
    }

    private Person createPerson() {
        Person person = new Person();
        person.setFirstName("Sandra");
        person.setLastName("Parsick");
        person.setJobTitle("Developer");
        return person;
    }

}