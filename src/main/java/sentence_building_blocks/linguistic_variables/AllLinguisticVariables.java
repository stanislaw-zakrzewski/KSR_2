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
    }
}
