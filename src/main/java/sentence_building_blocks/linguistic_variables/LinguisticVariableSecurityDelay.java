package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableSecurityDelay extends LinguisticVariable {
    private static final int min = 0;
    private static final int max = 103;

    LinguisticVariableSecurityDelay() {
        name = "spóźnienie z powodu względów bezpieczeństwa";
        column = "security_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o średnim spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o dużym spoźnieniu spowodowanym przez względy bezpieczeństwa");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(15, 20, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(15, 25, 35, 45, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(35, 50, min, max));
    }
}
