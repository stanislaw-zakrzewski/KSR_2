package sentence_building_blocks.qualifiers;

import model.membership_functions.MembershipFunction;
import model.qualifiers.Qualifier;

public class QualifierExample implements Qualifier {
    private String name;
    private MembershipFunction membershipFunction;

    public QualifierExample(String name, MembershipFunction membershipFunction) {
        this.name = name;
        this.membershipFunction = membershipFunction;
    }

    public String getName() {
        return name;
    }

    @Override
    public float calculateMembership(float value) {
        return membershipFunction.calculateMembership(value);
    }
}
