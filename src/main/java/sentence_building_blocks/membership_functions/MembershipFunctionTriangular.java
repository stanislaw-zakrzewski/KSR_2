package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class TriangleMembershipFunction implements MembershipFunction {
    private float beginning;
    private float middle;
    private float end;

    public TriangleMembershipFunction(float beginning, float middle, float end) {
        this.beginning = beginning;
        this.middle = middle;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= beginning) return 0;
        else if (beginning < value && value <= middle) return ((value - beginning) / (middle - beginning));
        else if (middle < value && value <= end) return ((end - value) / (end - middle));
        else return 0;
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float b, e;
        if (beggingValue > beginning) b = beggingValue;
        else b = beginning;
        if (endValue < end) e = endValue;
        else e = end;
        return e - b;
    }

    @Override
    public float getIntegralValue(float beggingValue, float endValue) {
        float b, e;
        if (beggingValue > beginning) b = beggingValue;
        else b = beginning;
        if (endValue < end) e = endValue;
        else e = end;
        return ((e - b)*(calculateMembership(middle) - 0))/2;
    }
}
