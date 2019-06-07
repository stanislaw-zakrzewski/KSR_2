package sentence_building_blocks.qualifiers;

import model.membership_functions.MembershipFunction;
import model.linguistic_quantifiers.LinguisticQuantifier;

public class LinguisticQuantifierExample implements LinguisticQuantifier {
    private String name;
    private MembershipFunction membershipFunction;

    public LinguisticQuantifierExample(String name, MembershipFunction membershipFunction) {
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
}
