package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableDepartureDelay extends LinguisticVariable {
    private static final int min = -20;
    private static final int max = 1413;

    LinguisticVariableDepartureDelay() {
        name = "spóźnienie odlotu";
        column = "dep_delay";
        labels = Arrays.asList("lotami o spóźnionym odlocie", "lotami o bardzo spóźnionym odlocie");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(25, 35, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionGammaClass(25, 35, min, max));
    }
}
