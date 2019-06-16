package sentence_building_blocks.linguistic_variables;

import model.linguistic_variables.LinguisticVariable;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;

import java.util.Arrays;
import java.util.HashMap;

class LinguisticVariableWeatherDelay extends LinguisticVariable {
    LinguisticVariableWeatherDelay() {
        name = "spóźnienie przez pogodę";
        column = "weather_delay";
        labels = Arrays.asList("lotami o małym spoźnieniu spowodowanym przez pogodę", "lotami o średnim spoźnieniu spowodowanym przez pogodę", "lotami o dużym spoźnieniu spowodowanym przez pogodę");
        membershipFunctions = new HashMap<>();
        membershipFunctions.put(labels.get(0), new MembershipFunctionTrapezoidal(0, 0.001f, 240, 260));
        membershipFunctions.put(labels.get(1), new MembershipFunctionTrapezoidal(230, 270, 540, 620));
        membershipFunctions.put(labels.get(2), new MembershipFunctionGammaClass(600, 800));
    }
}
