package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionLClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableDayOfWeek extends LinguisticVariable {
    private static final int min = 1;
    private static final int max = 7;

    LinguisticVariableDayOfWeek() {
        name = "wystąpienie w tygodniu";
        column = "day_of_week";
        labels = Arrays.asList("lotami, które odbyły się na początku tygodnia ", "lotami, które odbyły się w połowie tygodnia", "lotami, które odbyły się pod koniec tygodnia");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionLClass(2, 3, min, max));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(2, 3, 5, 6, min, max));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(5, 6, min, max));
    }
}
