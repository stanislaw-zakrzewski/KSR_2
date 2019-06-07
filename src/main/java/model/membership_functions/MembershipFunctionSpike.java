package model.membership_functions;

public class MembershipFunctionSpike implements MembershipFunction {
    private float point;
    private float width;

    public MembershipFunctionSpike(float point, float width) {
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
}
