package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionGammaClass implements MembershipFunction {
    private float a;
    private float b;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionGammaClass(float a, float b, float minimumValue, float maximumValue) {
        this.a = a;
        this.b = b;
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
    public float getSupport() {//TODO check
       /* float b;
        if (beggingValue > a) b = beggingValue;
        else b = a;
        return endValue - b;*/
        return 1;
    }

    @Override
    public float getIntegralValue() {//TODO check
        /*float b;
        if (beggingValue > a) b = beggingValue;
        else b = a;

        float tp = ((endValue - b) * (calculateMembership(endValue) - calculateMembership(beggingValue))) / 2;
        float pp = (endValue - this.b);
        return tp + pp;
         */
        return 1;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
