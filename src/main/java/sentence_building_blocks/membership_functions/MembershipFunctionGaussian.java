package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;
import org.apache.commons.math3.special.Erf;

public class MembershipFunctionGaussian implements MembershipFunction {
    private float a; //szerokość ale jakaś dziwna, dla 2 jest 10 dla 4 jest 20 itp.
    private float b; //middle
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
    public float getIntegralValue() {
        double end = -0.5 * Math.sqrt(Math.PI) * a * Erf.erf((b - maximumValue) / a);
        double beg = -0.5 * Math.sqrt(Math.PI) * a * Erf.erf((b - minimumValue) / a);

        return (float) (end - beg);
    }

    @Override
    public float getRange() {
        return maximumValue - minimumValue;
    }
}
