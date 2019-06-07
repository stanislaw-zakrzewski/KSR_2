package model;

import lombok.Getter;
import model.membership_functions.MembershipFunction;

import java.util.LinkedList;

public class FuzzySet {
    @Getter
    private LinkedList<FuzzyPair> fuzzySet;
    private MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
        fuzzySet = new LinkedList<>();
    }

    public void addValue(float value) {
        fuzzySet.add(new FuzzyPair(value, membershipFunction.calculateMembership(value)));
    }

    public float getCardinality() {
        float cardinality = 0;
        for(FuzzyPair fp : fuzzySet) {
            cardinality += fp.getMembership();
        }
        return cardinality;
    }

    public int getSize() {
        return fuzzySet.size();
    }
}
