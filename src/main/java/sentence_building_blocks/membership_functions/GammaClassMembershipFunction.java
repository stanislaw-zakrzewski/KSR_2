package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class GammaClassMembershipFunction implements MembershipFunction {
    private float begging;
    private float end;

    public GammaClassMembershipFunction(float begging, float end) {
        this.begging = begging;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= begging) return 0;
        else if (begging < value && value <= end) return ((value-begging)/(end-begging));
        else return 1;
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float b;
        if (beggingValue > begging) b = beggingValue;
        else b = begging;
        return endValue - b;
    }
}
