package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class SClassMembershipFunction implements MembershipFunction {
    private float begging;
    private float end;

    public SClassMembershipFunction(float begging, float end) {
        this.begging = begging;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        float b = ((begging +end)/2);

        if (value <= begging) return 0;
        else if (begging < value && value <= b) return (float) (2 * Math.pow(((value - begging) / (end - begging)), 2));
        else if (b < value && value <= end) return (float) (1 - (2 * Math.pow(((value - end) / (end - begging)), 2)));
        else return 1;
    }
}
