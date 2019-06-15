package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableSecurityDelay extends LinguisticVariable {
    public LinguisticVariableSecurityDelay() {
        name = "spóźnienie przez bezpieczeństwo";
        column = "security_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o średnim spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o dużym spoźnieniu spowodowanym przez względy bezpieczeństwa");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 5));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(5, 15));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(15, 2000000000));
    }
}
