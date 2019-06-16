package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableFlightDistance extends LinguisticVariable {
    LinguisticVariableFlightDistance() {
        name = "długość lotu";
        column = "distance";
        labels = Arrays.asList("lotami międzymiastowymi", "lotami krótkodystansowymi", "lotami średniodystansowymi", "lotami długodystansowymi", "lotami bardzo długosystansowymi");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0, 0.001f, 90, 120));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(100, 150, 600, 750));
        membershipFunctions.put(labels.get(2), new MembershipFunctionTrapezoidal(700, 900, 1400, 1700));
        membershipFunctions.put(labels.get(3), new MembershipFunctionTrapezoidal(1500, 1800, 3000, 3300));
        membershipFunctions.put(labels.get(4), new MembershipFunctionGammaClass(3200, 3500));
    }
}
