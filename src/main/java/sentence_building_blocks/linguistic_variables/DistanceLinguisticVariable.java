package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class DistanceLinguisticVariable extends LinguisticVariable {
    public DistanceLinguisticVariable() {
        name = "długość lotu";
        column = "distance";
        labels = Arrays.asList("bardzo krótki lot", "krótki lot", "średni lot", "długi lot", "bardzo długi lot");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 100));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(100, 700));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(700, 1500));
        membershipFunctions.put(labels.get(3), new SClassMembershipFunction(1500, 3000));
        membershipFunctions.put(labels.get(4), new SClassMembershipFunction(3000, 2000000000));
    }
}
