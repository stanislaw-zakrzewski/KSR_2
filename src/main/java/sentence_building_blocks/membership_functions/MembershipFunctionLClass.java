package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionLClass implements MembershipFunction {
    private float a;
    private float b;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionLClass(float a, float b, float minimumValue, float maximumValue) {
        if (a < minimumValue) {
            this.a = minimumValue;
        } else {
            this.a = a;
        }
        if (b > maximumValue) {
            this.b = maximumValue;
        } else {
            this.b = b;
        }
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= a) return 1;
        else if (a < value && value <= b) return ((b - value) / (b - a));
        else return 0;
    }

    @Override
    public float getSupport() {
        return a - minimumValue;
    }

    @Override
    public float getIntegralValue() {
        return a - minimumValue + (b - a) / 2;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
