package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableCarrierDelay extends LinguisticVariable {
    public LinguisticVariableCarrierDelay() {
        name = "spóźnienie przez przewoźnika";
        column = "carrier_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez przewodnika", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez przewodnika");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 50));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(50, 200));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(200, 2000000000));
    }
}
