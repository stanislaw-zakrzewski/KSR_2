package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableFlightDistance extends LinguisticVariable {
    private static final int min = 45;
    private static final int max = 4983;

    LinguisticVariableFlightDistance() {
        name = "długość lotu";
        column = "distance";
        labels = Arrays.asList("lotami międzymiastowymi", "lotami krótkodystansowymi", "lotami średniodystansowymi", "lotami długodystansowymi", "lotami bardzo długosystansowymi");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(90, 120, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(100, 150, 600, 750, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionTrapezoidal(700, 900, 1400, 1700, min, max));
        membershipFunctions.put(labels.get(3), new MembershipFunctionTrapezoidal(1500, 1800, 3000, 3300, min, max));
        membershipFunctions.put(labels.get(4), new MembershipFunctionGammaClass(3200, 3500, min, max));
    }
}
