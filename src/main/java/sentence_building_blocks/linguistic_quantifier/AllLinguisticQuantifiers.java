package sentence_building_blocks.linguistic_quantifier;

import lombok.Getter;
import model.linguistic_quantifiers.LinguisticQuantifier;
import sentence_building_blocks.membership_functions.MembershipFunctionGammaClass;
import sentence_building_blocks.membership_functions.MembershipFunctionGaussian;
import sentence_building_blocks.membership_functions.MembershipFunctionTrapezoidal;
import sentence_building_blocks.membership_functions.MembershipFunctionTriangular;

import java.util.LinkedList;

public class AllLinguisticQuantifiers {
    @Getter
    LinkedList<LinguisticQuantifier> linguisticQuantifiers;

    public AllLinguisticQuantifiers() {
        linguisticQuantifiers = new LinkedList<>();
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("mało", new MembershipFunctionTriangular(0,0.3f,0.6f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("dużo", new MembershipFunctionTriangular(0.4f,0.7f,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("ponad połowa", new MembershipFunctionGammaClass(0.4f,0.5f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("mniej niż połowa", new MembershipFunctionTrapezoidal(0,0.001f, 0.5f, 0.6f)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelativeTriangular("około połowy", new MembershipFunctionGaussian(0.4f,0.5f)));
    }
}
