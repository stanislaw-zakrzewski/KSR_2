package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionExample2;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableArriveDelay extends LinguisticVariable {
    public LinguisticVariableArriveDelay() {
        name = "spóźnienie przyloty";
        column = "arr_delay";
        labels = Arrays.asList("lotami o spóźnionym przylocie", "lotami o bardzo spóźnionym przylocie");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionExample2(0, 30));
        membershipFunctions.put(labels.get(1), new MembershipFunctionExample2(30, 1000000));
    }
}
