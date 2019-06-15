package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableDayOfWeek extends LinguisticVariable {
    LinguisticVariableDayOfWeek() {
        name = "dzień tygodnia";
        column = "day_of_week";
        labels = Arrays.asList("lotami, które odbyły się na początku tygodnia ", "lotami, które odbyły się w połowie tygodnia", "lotami, które odbyły się pod koniec tygodnia");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0, 1, 2, 3));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(2, 3, 5, 6));
        membershipFunctions.put(labels.get(2), new MembershipFunctionTrapezoidal(5, 6, 7, 8));
    }
}
