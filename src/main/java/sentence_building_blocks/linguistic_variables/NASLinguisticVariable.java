package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class NASLinguisticVariable extends LinguisticVariable {
    public NASLinguisticVariable() {
        name = "spóźnienie przez National Aviation System";
        column = "nas_delay";
        labels = Arrays.asList("mało spóźniony", "trochę spóźniony", "bardzo spóźniony");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 100));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(100, 300));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(300, 2000000000));
    }
}
