package sentence_building_blocks.linguistic_variables;

import lombok.Getter;
import model.linguistic_variables.LinguisticVariable;

import java.util.LinkedList;

public class AllLinguisticVariables {
    @Getter
    LinkedList<LinguisticVariable> linguisticVariables;

    public AllLinguisticVariables() {
        linguisticVariables = new LinkedList<>();
        linguisticVariables.add(new LinguisticVariableDepartureDelay());
        linguisticVariables.add(new LinguisticVariableArriveDelay());
        linguisticVariables.add(new LinguisticVariableFlightDistance());
        linguisticVariables.add(new LinguisticVariableWeatherDelay());
        linguisticVariables.add(new LinguisticVariableLateAircraftDelay());
        linguisticVariables.add(new LinguisticVariableSecurityDelay());
        linguisticVariables.add(new LinguisticVariableNASDelay());
        linguisticVariables.add(new LinguisticVariableCarrierDelay());
        linguisticVariables.add(new LinguisticVariableDayOfWeek());
        linguisticVariables.add(new LinguisticVariableDayOfMonth());
    }
}
