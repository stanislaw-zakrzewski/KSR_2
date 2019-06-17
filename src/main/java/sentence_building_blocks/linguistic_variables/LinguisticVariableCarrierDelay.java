package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableCarrierDelay extends LinguisticVariable {
    private static final int min = 0;
    private static final int max = 1354;

    LinguisticVariableCarrierDelay() {
        name = "spóźnienie z powodu przewoźnika";
        column = "carrier_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez przewodnika", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez przewodnika");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(40, 60, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(40, 70, 190, 210, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(200, 240, min, max));
    }
}
