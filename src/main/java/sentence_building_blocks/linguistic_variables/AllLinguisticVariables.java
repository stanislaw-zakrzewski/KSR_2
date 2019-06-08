package sentence_building_blocks.linguistic_variables;

import lombok.Getter;
import model.linguistic_variables.LinguisticVariable;

import java.util.LinkedList;

public class AllLinguisticVariables {
    @Getter
    LinkedList<LinguisticVariable> linguisticVariables;

    public AllLinguisticVariables() {
        linguisticVariables = new LinkedList<>();
        linguisticVariables.add(new LinguisticVariableExample());
        linguisticVariables.add(new LinguisticVariableExample2());
        linguisticVariables.add(new DistanceLinguisticVariable());
        linguisticVariables.add(new WeatherLinguisticVariable());
        linguisticVariables.add(new AircraftLinguisticVariable());
        linguisticVariables.add(new SecurityLinguisticVeriable());
        linguisticVariables.add(new NASLinguisticVariable());
        linguisticVariables.add(new CarrierLinguisticVariable());
    }
}
