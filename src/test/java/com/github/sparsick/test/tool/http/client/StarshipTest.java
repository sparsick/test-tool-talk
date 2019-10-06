package com.github.sparsick.test.tool.http.client;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class StarshipTest {

    @Test
    void equalsContractVerySimple(){
        Starship starship1 = createStarship();
        Starship starship2 = createStarship();
        starship2.setStarshipClass("new Starshipclass");

        assertThat(starship1).isNotEqualTo(starship2);
        assertThat(starship1.hashCode()).isNotEqualTo(starship2.hashCode());
    }

    @Test
    void equalsContractMuchBetter(){
        EqualsVerifier.forClass(Starship.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    private Starship createStarship() {
        Starship starship = new Starship();
        starship.setName("Executor");
        starship.setModel("Executor-class star dreadnought");
        starship.setCostInCredits("1143350000");
        starship.setLength(19000d);
        starship.setMaxAtmospheringSpeed("n/a");
        starship.setCrew(279144);
        starship.setPassengers(38000);
        starship.setCargoCapacity("250000000");
        starship.setConsumables("6 years");
        starship.setHyperdriveRating(2.0);
        starship.setMglt(40);
        starship.setStarshipClass("Star dreadnought");

        return starship;
    }

    @Test
    void convertFromJsonMap(){
        Map jsonMap = new HashMap();
        jsonMap.put("name", "Executor");
        jsonMap.put("model", "Executor-class star dreadnought");
        jsonMap.put("cost_in_credits", "1143350000");
        jsonMap.put("length", "19000");
        jsonMap.put("max_atmosphering_speed", "n/a");
        jsonMap.put("crew", "279144");
        jsonMap.put("passengers", "38000");
        jsonMap.put("cargo_capacity", "250000000");
        jsonMap.put("consumables", "6 years");
        jsonMap.put("hyperdrive_rating", "2.0");
        jsonMap.put("MGLT", "40");
        jsonMap.put("starship_class", "Star dreadnought");
        jsonMap.put("pilots", "");

        Starship starship = Starship.from(jsonMap);

        assertThat(starship).isEqualTo(expectedStarship());
    }

    private Starship expectedStarship() {
        Starship starship = new Starship();
        starship.setName("Executor");
        starship.setModel("Executor-class star dreadnought");
        starship.setCostInCredits("1143350000");
        starship.setLength(19000d);
        starship.setMaxAtmospheringSpeed("n/a");
        starship.setCrew(279144);
        starship.setPassengers(38000);
        starship.setCargoCapacity("250000000");
        starship.setConsumables("6 years");
        starship.setHyperdriveRating(2.0);
        starship.setMglt(40);
        starship.setStarshipClass("Star dreadnought");

        return starship;
    }

}