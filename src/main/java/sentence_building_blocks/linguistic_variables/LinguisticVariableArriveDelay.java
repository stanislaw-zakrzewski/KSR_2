package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableArriveDelay extends LinguisticVariable {
    private static final int min = -47;
    private static final int max = 1442;

    LinguisticVariableArriveDelay() {
        name = "spóźnienie przyloty";
        column = "arr_delay";
        labels = Arrays.asList("lotami o spóźnionym przylocie", "lotami o bardzo spóźnionym przylocie");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(60, 80, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionGammaClass(60, 80, min, max));
    }
}
