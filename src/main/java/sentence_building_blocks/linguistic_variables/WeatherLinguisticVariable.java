package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class WeatherLinguisticVariable extends LinguisticVariable {
    public WeatherLinguisticVariable() {
            name = "spóźnienie przez pogodę";
            column = "weather_delay";
            labels = Arrays.asList("mało spóźniony przez pogodę", "trochę spóźniony przez pogodę", "bardzo spóźniony przez pogodę");
            membershipFunctions = new HashMap<>();
            membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 250));
            membershipFunctions.put(labels.get(1), new SClassMembershipFunction(250, 600));
            membershipFunctions.put(labels.get(2), new SClassMembershipFunction(600, 2000000000));
    }
}
