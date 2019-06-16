package model.linguistic_quantifiers;

public interface LinguisticQuantifier {
    String getName();
    float calculateMembership(float value);
    float getCardinality();
    float getSupp();
    float getSize();
    boolean isAbsolute();
    int getValue();
}
