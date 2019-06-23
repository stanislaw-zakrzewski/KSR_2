package sentence_building_blocks.linguistic_quantifier;

import lombok.Getter;
import model.linguistic_quantifiers.LinguisticQuantifier;
import sentence_building_blocks.membership_functions.*;

import java.util.LinkedList;

public class AllLinguisticQuantifiers {
    private static final int min = 0;
    private static final int max = 1;
    private static final int maxAbsolute = 10000;
    @Getter
    LinkedList<LinguisticQuantifier> linguisticQuantifiers;

    public AllLinguisticQuantifiers(int X) {
        linguisticQuantifiers = new LinkedList<>();
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("mało", new MembershipFunctionTriangular(0, 0.3f, 0.6f, min, max)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("dużo", new MembershipFunctionTriangular(0.4f, 0.7f, 1, min, max)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("ponad połowa", new MembershipFunctionGammaClass(0.4f, 0.5f, min, max)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("mniej niż połowa", new MembershipFunctionLClass(0.5f, 0.6f, min, max)));
        linguisticQuantifiers.add(new LinguisticQuantifierRelative("około połowy", new MembershipFunctionGaussian(0.2f, 0.5f, min, max)));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("mniej niż", new MembershipFunctionLClass(X * 0.9f, X * 1.1f, min, maxAbsolute), X));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("więcej niż", new MembershipFunctionGammaClass(X * 0.9f, X * 1.1f, min, maxAbsolute), X));
        linguisticQuantifiers.add(new LinguisticQuantifierAbsolute("około", new MembershipFunctionGaussian(X * 0.1f, X, min, maxAbsolute), X));
    }
}
