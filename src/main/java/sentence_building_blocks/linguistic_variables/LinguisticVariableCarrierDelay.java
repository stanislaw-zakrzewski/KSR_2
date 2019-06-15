package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionSClass;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableCarrierDelay extends LinguisticVariable {
    LinguisticVariableCarrierDelay() {
        name = "spóźnienie przez przewoźnika";
        column = "carrier_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez przewodnika", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez przewodnika");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionSClass(0, 50));
        membershipFunctions.put(labels.get(1), new MembershipFunctionSClass(50, 200));
        membershipFunctions.put(labels.get(2), new MembershipFunctionSClass(200, 2000000000));
    }
}
