package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionTrapezoidal implements MembershipFunction {
    private float begging;
    private float beggingTop;
    private float endTop;
    private float end;

    public MembershipFunctionTrapezoidal(float begging, float beggingTop, float endTop, float end) {
        this.begging = begging;
        this.beggingTop = beggingTop;
        this.endTop = endTop;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= begging) return 0;
        else if (begging < value && value <= beggingTop) return ((value - begging) / (beggingTop - begging));
        else if (beggingTop < value && value <= endTop) return 1;
        else if (endTop < value && value <= end) return ((end - value) / (end - endTop));
        else return 0;
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float b, e;
        if (beggingValue > begging) b = beggingValue;
        else b = begging;
        if (endValue < end) e = endValue;
        else e = end;
        return e - b;
    }

    @Override
    public float getIntegralValue(float beggingValue, float endValue) {
        float b, e;
        if (beggingValue > begging) b = beggingValue;
        else b = begging;
        if (endValue < end) e = endValue;
        else e = end;

        return ((endTop - beggingTop) + (e - b)) / 2;
    }
}
