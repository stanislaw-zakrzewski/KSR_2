package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class GaussianMembershipFunction implements MembershipFunction {
    private float width;
    private float middle;

    public GaussianMembershipFunction(float width, float middle) {
        this.width = width;
        this.middle = middle;
    }

    @Override
    public float calculateMembership(float value) {
        return (float) Math.exp(-(Math.pow(((value - middle) / width), 2)));
    }
}
