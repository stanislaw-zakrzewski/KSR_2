package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableDayOfMonth extends LinguisticVariable {
    private static final int min = 1;
    private static final int max = 31;

    LinguisticVariableDayOfMonth() {
        name = "wystąpienie w miesiącu";
        column = "day_of_month";
        labels = Arrays.asList("lotami, które odbyły się na początku miesiąca", "lotami, które odbyły się w połowie miesiąca", "lotami, które odbyły się pod koniec miesiąca");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(3, 6, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(11, 14, 17, 20, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(25, 29, min, max));
    }
}
