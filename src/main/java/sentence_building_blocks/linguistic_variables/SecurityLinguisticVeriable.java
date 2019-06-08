package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class SecurityLinguisticVeriable extends LinguisticVariable {
    public SecurityLinguisticVeriable() {
        name = "spóźnienie przez bezpieczeństwo";
        column = "security_delay";
        labels = Arrays.asList("mało spóźniony", "trochę spóźniony", "bardzo spóźniony");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 5));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(5, 15));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(15, 2000000000));
    }
}