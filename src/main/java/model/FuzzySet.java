package model;

import model.membership_functions.MembershipFunction;

import java.util.LinkedList;

public class FuzzySet {
    private LinkedList<FuzzyPair> fuzzySet;
    private MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
        fuzzySet = new LinkedList<>();
    }

    public void addValue(float value) {
        fuzzySet.add(new FuzzyPair(value, membershipFunction.calculateMembership(value)));
    }

    public LinkedList<FuzzyPair> getFuzzySet() {
        return fuzzySet;
    }
}
