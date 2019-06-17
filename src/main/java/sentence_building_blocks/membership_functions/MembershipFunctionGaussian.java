package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;
import org.apache.commons.math3.special.Erf;

public class MembershipFunctionGaussian implements MembershipFunction {
    private float a;
    private float b;
    private float minimumValue;
    private float maximumValue;

    public MembershipFunctionGaussian(float a, float b, float minimumValue, float maximumValue) {
        this.a = a;
        this.b = b;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    @Override
    public float calculateMembership(float value) {
        return (float) Math.exp(-(Math.pow(((value - b) / a), 2)));
    }

    @Override
    public float getSupport() {//TODO check
        float x = (a + b) / 4;
        return (b + x) - (b - x);
    }

    @Override
    public float getIntegralValue() {//TODO check
        /* double end = -0.5 * Math.sqrt(Math.PI) * b * Erf.erf((b - endValue) / a);
        double beg = -0.5 * Math.sqrt(Math.PI) * b * Erf.erf((b - beggingValue) / a);

        return (float) (end - beg);*/
        return 1;
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
