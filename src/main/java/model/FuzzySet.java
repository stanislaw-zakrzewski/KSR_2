package model;

import lombok.Getter;
import model.membership_functions.MembershipFunction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FuzzySet {
    @Getter
    private LinkedList<FuzzyPair> fuzzySet;
    private MembershipFunction membershipFunction;
    private Map<Float, Float> valueMembership;

    public FuzzySet() {
        valueMembership = new HashMap<>();
        fuzzySet = new LinkedList<>();
    }

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
        valueMembership = new HashMap<>();
        fuzzySet = new LinkedList<>();
    }

    public void addValue(float value) {
        fuzzySet.add(new FuzzyPair(value, membershipFunction.calculateMembership(value)));
        valueMembership.put(value, fuzzySet.getLast().getMembership());
    }

    public void addValue(float value, float membership) {
        fuzzySet.add(new FuzzyPair(value, membership));
        valueMembership.put(value, membership);
    }

    public float getCardinality() {
        float cardinality = 0;
        for (FuzzyPair fp : fuzzySet) {
            cardinality += fp.getMembership();
        }
        return cardinality;
    }

    public float getSupp() {
        int supp = 0;
        for (FuzzyPair fp : fuzzySet) {
            if (fp.getMembership() > 0) supp++;
        }
        return supp;
    }

    public int getSize() {
        return fuzzySet.size();
    }

    public float getMembership(float value) {
        return valueMembership.get(value);
    }
}
