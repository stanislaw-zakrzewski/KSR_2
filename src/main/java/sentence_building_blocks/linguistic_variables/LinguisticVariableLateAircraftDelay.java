package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableLateAircraftDelay extends LinguisticVariable {
    LinguisticVariableLateAircraftDelay() {
        name = "spóźnienie spowodowane późnym przylotem samolotu";
        column = "late_aircraft_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu", "lotami o średnim spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu", "lotami o dużym spoźnieniu spowodowanym przez opóźnienie w przylocie samolotu");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0,0.001f, 40,60));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(40,70, 150,180));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(160, 200));
    }
}
