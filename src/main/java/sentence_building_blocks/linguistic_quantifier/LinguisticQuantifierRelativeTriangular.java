package sentence_building_blocks.linguistic_quantifier;

import model.membership_functions.MembershipFunction;
import model.linguistic_quantifiers.LinguisticQuantifier;

public class LinguisticQuantifierRelativeTriangular implements LinguisticQuantifier {
    private String name;
    private MembershipFunction membershipFunction;

    public LinguisticQuantifierRelativeTriangular(String name, MembershipFunction membershipFunction) {
        this.name = name;
        this.membershipFunction = membershipFunction;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float calculateMembership(float value) {
        return membershipFunction.calculateMembership(value);
    }

    @Override
    public float getCardinality() {
        return membershipFunction.getIntegralValue(0,1);
    }

    @Override
    public float getSupp() {
        return membershipFunction.getSupport(0, 1);
    }

    @Override
    public float getSize() {
        return 1;
    }
}
