package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class MembershipFunctionExample implements MembershipFunction {
    private float point;
    private float width;

    public MembershipFunctionExample(float point, float width) {
        this.point = point;
        this.width = width;
    }

    @Override
    public float calculateMembership(float value) {
        if (value >= point - width / 2 && value <= point + width / 2) {
            return 1.0f - Math.abs(point - value) / width * 2.0f;
        } else {
            return 0;
        }
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        return 0;
    }

    @Override
    public float getIntegralValue(float beggingValue, float endValue) {
        return 0;
    }
}
