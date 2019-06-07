package model;

public class FuzzyPair {
    private float value;
    private float membership;

    public FuzzyPair(float value, float membership) {
        this.value = value;
        this.membership = membership;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMembership() {
        return membership;
    }

    public void setMembership(float membership) {
        this.membership = membership;
    }
}
