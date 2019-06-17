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

    public AllLinguisticQuantifiers(int X) {
        linguisticQuantifiers = new LinkedList<>();
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("mało", new MembershipFunctionTriangular(0, 0.3f, 0.6f,0,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("dużo", new MembershipFunctionTriangular(0.4f, 0.7f, 1,0,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("ponad połowa", new MembershipFunctionGammaClass(0.4f, 0.5f,0,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("mniej niż połowa", new MembershipFunctionTrapezoidal(0, 0.001f, 0.5f, 0.6f,0,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("około połowy", new MembershipFunctionGaussian(0.2f, 0.5f,0,1)));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("mniej niż", new MembershipFunctionTrapezoidal(0, 0.001f, X, X * 1.1f,0,1), X));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("więcej niż", new MembershipFunctionGammaClass(X * 0.9f, X,0,1), X));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("około", new MembershipFunctionGaussian(X * 0.1f, X,0,1), X));
    }
}
