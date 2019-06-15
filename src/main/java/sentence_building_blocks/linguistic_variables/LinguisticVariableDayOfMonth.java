package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.TrapezoidalMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableDayOfMonth extends LinguisticVariable {
    public LinguisticVariableDayOfMonth() {
        name = "dzień miesiąca";
        column = "day_of_month";
        labels = Arrays.asList("lotami, które odbyły się na początku miesiąca ", "lotami, które odbyły się w połowie miesiąca", "lotami, które odbyły się pod koniec miesiąca");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new TrapezoidalMembershipFunction(0, 1, 3, 6));
        membershipFunctions.put(labels.get(1), new TrapezoidalMembershipFunction(9, 12, 16, 19));
        membershipFunctions.put(labels.get(2), new TrapezoidalMembershipFunction(25, 29, 31, 32));
    }
}
