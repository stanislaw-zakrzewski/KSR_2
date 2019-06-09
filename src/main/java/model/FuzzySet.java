package model;

import lombok.Getter;
import model.membership_functions.MembershipFunction;

import java.util.LinkedList;
import java.util.List;

public class FuzzySet {
    @Getter
    private LinkedList<FuzzyPair> fuzzySet;
    private MembershipFunction membershipFunction;
    @Getter
    private List<Float> values;
    @Getter
    private List<Float> memberships;
    private float cardinality;

    public FuzzySet() {
        fuzzySet = new LinkedList<>();
        values = new LinkedList<>();
        memberships = new LinkedList<>();
        cardinality = 0;
    }

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
        fuzzySet = new LinkedList<>();
        values = new LinkedList<>();
        memberships = new LinkedList<>();
        cardinality = 0;
    }

    public void addValue(float value) {
        float membership = membershipFunction.calculateMembership(value);
        fuzzySet.add(new FuzzyPair(value, membership));
        values.add(value);
        memberships.add(membership);
        cardinality += membership;
    }

    public void addValue(float value, float membership) {
        fuzzySet.add(new FuzzyPair(value, membership));
        values.add(value);
        memberships.add(membership);
        cardinality += membership;
    }

    public float getCardinality() {
        return cardinality;
    }

    public float getSupp() {
        int supp = 0;
        for (FuzzyPair fp : fuzzySet) {
            if (fp.getMembership() > 0) supp++;
        }
        return supp;
    }

    public float getMembershipForElement(int element) {
        return memberships.get(element);
    }

    public int getSize() {
        return fuzzySet.size();
    }
}
