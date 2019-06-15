package sentence_building_blocks.linguistic_quantifier;

import lombok.Getter;
import model.linguistic_quantifiers.LinguisticQuantifier;
import sentence_building_blocks.membership_functions.GammaClassMembershipFunction;
import sentence_building_blocks.membership_functions.GaussianMembershipFunction;
import sentence_building_blocks.membership_functions.TrapezoidalMembershipFunction;
import sentence_building_blocks.membership_functions.TriangleMembershipFunction;

import java.util.LinkedList;

public class AllLinguisticQuantifiers {
    @Getter
    LinkedList<LinguisticQuantifier> linguisticQuantifiers;

    public AllLinguisticQuantifiers() {
        linguisticQuantifiers = new LinkedList<>();
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("mało", new TriangleMembershipFunction(0,0.3f,0.6f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("dużo", new TriangleMembershipFunction(0.4f,0.7f,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("ponad połowa", new GammaClassMembershipFunction(0.4f,0.5f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("mniej niż połowa", new TrapezoidalMembershipFunction(0,0.001f, 0.5f, 0.6f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("około połowy", new GaussianMembershipFunction(0.4f,0.5f)));
    }
}
