package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionTriangular implements MembershipFunction {
    private float a;
    private float b;
    private float c;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionTriangular(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public MembershipFunctionTriangular(float a, float b, float c, float minimumValue, float maximumValue) {//TODO check
        this.a = a;
        this.b = b;
        this.c = c;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= a) return 0;
        else if (a < value && value <= b) return ((value - a) / (b - a));
        else if (b < value && value <= c) return ((c - value) / (c - b));
        else return 0;
    }

    @Override
    public float getSupport() {
        return c - a;
    }

    @Override
    public float getIntegralValue() {
        return (c - a) / 2;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
