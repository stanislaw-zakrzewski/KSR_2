package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class AircraftLinguisticVariable extends LinguisticVariable {
    public AircraftLinguisticVariable() {
        name = "spóźnienie przez późno dotarty samolot";
        column = "late_aircraft_delay";
        labels = Arrays.asList("mało spóźniony", "trochę spóźniony", "bardzo spóźniony");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 50));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(50, 150));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(150, 2000000000));
    }
}
