package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableDepartureDelay extends LinguisticVariable {
    LinguisticVariableDepartureDelay() {
        name = "spóźnienie odlotu";
        column = "dep_delay";
        labels = Arrays.asList("lotami o spóźnionym odlocie", "lotami o bardzo spóźnionym odlocie");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(-1, 0,25,35));
        membershipFunctions.put(labels.get(1), new MembershipFunctionGammaClass(25, 35));
    }
}
