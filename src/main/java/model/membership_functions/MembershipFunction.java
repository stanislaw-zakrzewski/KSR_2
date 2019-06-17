package model.membership_functions;

public interface MembershipFunction {
    float calculateMembership(float value);
    float getSupport(float beggingValue, float endValue);
    float getIntegralValue(float beggingValue, float endValue);
    float getRange();
}
