package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableNASDelay extends LinguisticVariable {
    LinguisticVariableNASDelay() {
        name = "spóźnienie przez National Aviation System";
        column = "nas_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez NAS", "lotami o średnim spoźnieniu spowodowanym przez przewodnika", "lotami o dużym spoźnieniu spowodowanym przez NAS");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0, 0.001f, 90, 120));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(100, 140, 300, 340));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(320, 370));
    }
}
