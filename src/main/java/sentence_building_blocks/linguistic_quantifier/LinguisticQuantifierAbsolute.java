package sentence_building_blocks.linguistic_quantifier;

import model.linguistic_quantifiers.LinguisticQuantifier;
import model.membership_functions.MembershipFunction;

public class LinguisticQuantifierAbsolute implements LinguisticQuantifier {
    private String name;
    private MembershipFunction membershipFunction;
    private int value;

    public LinguisticQuantifierAbsolute(String name, MembershipFunction membershipFunction, int value) {
        this.name = name;
        this.membershipFunction = membershipFunction;
        this.value = value;
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
        return membershipFunction.getIntegralValue(0, 1);
    }

    @Override
    public float getSupp() {
        return membershipFunction.getSupport(0, 1);
    }

    @Override
    public float getSize() {
        return 1;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public int getValue() {
        return value;
    }
}
