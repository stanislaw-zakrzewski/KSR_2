package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionGammaClass implements MembershipFunction {
    private float a;
    private float b;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionGammaClass(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public MembershipFunctionGammaClass(float a, float b, float minimumValue, float maximumValue) {
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
        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= a) return 0;
        else if (a < value && value <= b) return ((value - a) / (b - a));
        else return 1;
    }

    @Override
    public float getSupport() {
        if (a < maximumValue) {
            if (a > minimumValue) {
                return maximumValue - a;
            } else {
                return maximumValue - minimumValue;
            }
        } else {
            return 0;
        }
    }

    @Override
    public float getIntegralValue() {
        return (b - a) / 2 + maximumValue - b;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
