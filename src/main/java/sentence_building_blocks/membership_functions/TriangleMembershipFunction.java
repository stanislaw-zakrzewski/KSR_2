package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class TriangleMembershipFunction implements MembershipFunction {
    private float begging;
    private float middle;
    private float end;

    public TriangleMembershipFunction(float begging, float middle, float end) {
        this.begging = begging;
        this.middle = middle;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= begging) return 0;
        else if (begging < value && value <= middle) return ((value - begging) / (middle - begging));
        else if (middle < value && value <= end) return ((end - value) / (end - middle));
        else return 0;
    }
}
