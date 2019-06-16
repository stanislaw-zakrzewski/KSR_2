package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableFlightDistance extends LinguisticVariable {
    LinguisticVariableFlightDistance() {
        name = "długość lotu";
        column = "distance";
        labels = Arrays.asList("lotami międzymiastowymi", "lotami krótkodystansowymi", "lotami średniodystansowymi", "lotami długodystansowymi", "lotami bardzo długosystansowymi");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionGammaClass(0, 100));
        membershipFunctions.put(labels.get(1), new MembershipFunctionGammaClass(100, 700));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(700, 1500));
        membershipFunctions.put(labels.get(3), new MembershipFunctionGammaClass(1500, 3000));
        membershipFunctions.put(labels.get(4), new MembershipFunctionGammaClass(3000, 2000000000));
    }
}
