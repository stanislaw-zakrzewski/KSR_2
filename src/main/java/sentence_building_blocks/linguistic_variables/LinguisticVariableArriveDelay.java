package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableArriveDelay extends LinguisticVariable {
    LinguisticVariableArriveDelay() {
        name = "spóźnienie przyloty";
        column = "arr_delay";
        labels = Arrays.asList("lotami o spóźnionym przylocie", "lotami o bardzo spóźnionym przylocie");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(-1, 0,25,35));
        membershipFunctions.put(labels.get(1), new MembershipFunctionGammaClass(25, 35));
    }
}
