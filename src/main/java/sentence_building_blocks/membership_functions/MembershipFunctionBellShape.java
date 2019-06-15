package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class BellidalMembershipFunction implements MembershipFunction {
    private float width;
    private float tilt;
    private float middle;

    public BellidalMembershipFunction(float width, float tilt, float middle) {
        this.width = width;
        this.tilt = tilt;
        this.middle = middle;
    }

    @Override
    public float calculateMembership(float value) {
        return (float) (1 / (1 + Math.pow(Math.abs((value - middle) / width), (2 * tilt))));
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float x = (width+middle)/4;
        return (middle+x) - (middle-x);
    }

    @Override
    public float getIntegralValue(float beggingValue, float endValue) {
        return 0; //TODO Immpossible?
    }
}