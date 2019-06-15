package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableNASDelay extends LinguisticVariable {
    public LinguisticVariableNASDelay() {
        name = "spóźnienie przez National Aviation System";
        column = "nas_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez NAS", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez NAS");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 100));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(100, 300));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(300, 2000000000));
    }
}
