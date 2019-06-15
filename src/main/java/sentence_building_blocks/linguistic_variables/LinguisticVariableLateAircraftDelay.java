package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.SClassMembershipFunction;

import java.util.Arrays;
import java.util.HashMap;

public class LinguisticVariableLateAircraftDelay extends LinguisticVariable {
    public LinguisticVariableLateAircraftDelay() {
        name = "spóźnienie przez późno dotarty samolot";
        column = "late_aircraft_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu", "lotami o średnim spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu", "lotami o dużym spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new SClassMembershipFunction(0, 50));
        membershipFunctions.put(labels.get(1), new SClassMembershipFunction(50, 150));
        membershipFunctions.put(labels.get(2), new SClassMembershipFunction(150, 2000000000));
    }
}
