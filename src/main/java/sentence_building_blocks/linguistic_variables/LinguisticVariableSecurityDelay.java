package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableSecurityDelay extends LinguisticVariable {
    LinguisticVariableSecurityDelay() {
        name = "spóźnienie z powodu względów bezpieczeństwa";
        column = "security_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o średnim spoźnieniu spowodowanym przez względy bezpieczeństwa", "lotami o dużym spoźnieniu spowodowanym przez względy bezpieczeństwa");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0, 0.001f, 7, 9));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(8, 12, 20, 23));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(21, 30));
    }
}
