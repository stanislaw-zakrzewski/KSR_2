package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableNASDelay extends LinguisticVariable {
    private static final int min = 0;
    private static final int max = 576;

    LinguisticVariableNASDelay() {
        name = "spóźnienie z powodu National Aviation System";
        column = "nas_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez NAS", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez NAS");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(90, 120, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(100, 140, 300, 340, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(320, 370, min, max));
    }
}
