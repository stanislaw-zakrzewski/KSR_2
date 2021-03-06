package model.membership_functions;

public interface MembershipFunction {
    float calculateMembership(float value);

    float getSupport();

    float getIntegralValue();

    float getRange();
}
