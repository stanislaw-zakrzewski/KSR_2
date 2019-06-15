package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.TrapezoidalMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableDayOfWeek extends LinguisticVariable {
    public LinguisticVariableDayOfWeek() {
        name = "dzień tygodnia";
        column = "day_of_week";
        labels = Arrays.asList("lotami, które odbyły się na początku tygodnia ", "lotami, które odbyły się w połowie tygodnia", "lotami, które odbyły się pod koniec tygodnia");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new TrapezoidalMembershipFunction(0, 1, 2, 3));
        membershipFunctions.put(labels.get(1), new TrapezoidalMembershipFunction(2, 3, 5, 6));
        membershipFunctions.put(labels.get(2), new TrapezoidalMembershipFunction(5, 6, 7, 8));
    }
}
