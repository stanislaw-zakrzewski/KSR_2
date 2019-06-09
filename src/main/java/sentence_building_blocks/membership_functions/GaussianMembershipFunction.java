package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;
import org.apache.commons.math3.special.Erf;

public class GaussianMembershipFunction implements MembershipFunction {
    private float width;
    private float middle;

    public GaussianMembershipFunction(float width, float middle) {
        this.width = width;
        this.middle = middle;
    }

    @Override
    public float calculateMembership(float value) {
        return (float) Math.exp(-(Math.pow(((value - middle) / width), 2)));
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float x = (width + middle) / 4;
        return (middle + x) - (middle - x);
    }

    @Override
    public float getIntegralValue(float beggingValue, float endValue) {
        //całka dla konca-całka dla początka
        double end = -0.5 * Math.sqrt(Math.PI) * middle * Erf.erf((middle - endValue) / width);
        double beg = -0.5 * Math.sqrt(Math.PI) * middle * Erf.erf((middle - beggingValue) / width);
        return (float) (end - beg);
    }
}
