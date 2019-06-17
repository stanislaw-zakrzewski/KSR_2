package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionTrapezoidal implements MembershipFunction {
    private float a;
    private float b;
    private float c;
    private float d;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionTrapezoidal(float a, float b, float c, float d, float minimumValue, float maximumValue) {//TODO sprawdzenia czy mniejsze/większe
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    @Override
    public float calculateMembership(float value) {
        if (value <= a) return 0;
        else if (a < value && value <= b) return ((value - a) / (b - a));
        else if (b < value && value <= c) return 1;
        else if (c < value && value <= d) return ((d - value) / (d - c));
        else return 0;
    }

    @Override
    public float getSupport() {
        return d - a;
    }

    @Override
    public float getIntegralValue() {
        float integral = 0;
        integral += (b - a) / 2;
        integral += c - b;
        integral += (d - c) / 2;
        return integral;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
