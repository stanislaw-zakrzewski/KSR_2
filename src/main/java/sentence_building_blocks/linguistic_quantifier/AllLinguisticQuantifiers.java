package sentence_building_blocks.linguistic_quantifier;

import lombok.Getter;
import model.linguistic_quantifiers.LinguisticQuantifier;
import sentence_building_blocks.membership_functions.MembershipFunctionExample;

import java.util.LinkedList;

public class AllLinguisticQuantifiers {
    @Getter
    LinkedList<LinguisticQuantifier> linguisticQuantifiers;

    public AllLinguisticQuantifiers() {
        linguisticQuantifiers = new LinkedList<>();
        linguisticQuantifiers.add(new LinguisticQuantifierExample("mało", new MembershipFunctionExample(0.3f,0.6f)));
        linguisticQuantifiers.add(new LinguisticQuantifierExample("dużo", new MembershipFunctionExample(0.7f,0.6f)));
    }
}
