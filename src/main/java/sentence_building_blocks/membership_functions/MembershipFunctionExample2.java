package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionExample2 implements MembershipFunction {
    private float beginning;
    private float end;

    public MembershipFunctionExample2(float beginning, float end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        if (value > beginning && value <= end) return 1;
        else return 0;
    }
}
