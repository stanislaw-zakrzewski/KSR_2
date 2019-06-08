package model.linguistic_variables;

import lombok.Setter;
import model.FuzzySet;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationLinguisticVariable {
    private LinguisticVariable s;
    private String sLabel;
    private CombinationLinguisticVariable a;
    private CombinationLinguisticVariable b;
    private Conjunctions conjunction;
    private FuzzySet fuzzySet;
    @Setter
    private List<Float> values;


    public CombinationLinguisticVariable(LinguisticVariable s, String sLabel) {
        this.s = s;
        this.sLabel = sLabel;
        fuzzySet = new FuzzySet(s.membershipFunctions.get(sLabel));
    }

    public CombinationLinguisticVariable(CombinationLinguisticVariable a, CombinationLinguisticVariable b, Conjunctions conjunction) {
        this.a = a;
        this.b = b;
        this.conjunction = conjunction;
    }

    public void process(List<Float> x) {
        for (Float f : x) {
            fuzzySet.addValue(f);
        }
    }

    public int getSize() {
        if (s == null) {
            return a.getSize() + b.getSize();
        } else {
            return 1;
        }
    }

    public int getSSize() {
        if(a == null) {
            return fuzzySet.getSize();
        } else return a.getSSize();
    }

    public float getCardinality() {
        float cardinality = 0;

        return cardinality;
    }

    public List<FuzzySet> getFuzzySets() {
        List<FuzzySet> fuzzySets;
        if (s == null) {
            fuzzySets = a.getFuzzySets();
            fuzzySets.addAll(b.getFuzzySets());
            return fuzzySets;
        }
        fuzzySets = new LinkedList<>();
        fuzzySets.add(fuzzySet);
        return fuzzySets;
    }

    public FuzzySet getFuzzySet() {
        if (fuzzySet == null) {
            fuzzySet = new FuzzySet();
            if (conjunction == Conjunctions.AND) {
                for (int i = 0; i < a.getFuzzySet().getSize(); i++) {
                    fuzzySet.addValue(1, Math.min(a.getFuzzySet().getFuzzySet().get(i).getMembership(), b.getFuzzySet().getFuzzySet().get(i).getMembership()));
                }
            } else {
                for (int i = 0; i < a.getFuzzySet().getSize(); i++) {
                    fuzzySet.addValue(1, Math.max(a.getFuzzySet().getFuzzySet().get(i).getMembership(), b.getFuzzySet().getFuzzySet().get(i).getMembership()));
                }
            }
        }
        return fuzzySet;
    }

    @Override
    public String toString() {
        if (s == null) {
            if (conjunction == Conjunctions.AND) {
                return a.toString() + " i " + b.toString();
            } else {
                return a.toString() + " lub " + b.toString();
            }
        }
        return sLabel;
    }
}
