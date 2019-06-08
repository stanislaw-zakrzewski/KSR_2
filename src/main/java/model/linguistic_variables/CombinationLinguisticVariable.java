package model.linguistic_variables;

import lombok.Setter;
import model.FuzzySet;

import java.util.Arrays;
import java.util.Collections;
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
    }

    public CombinationLinguisticVariable(CombinationLinguisticVariable a, CombinationLinguisticVariable b, Conjunctions conjunction) {
        this.a = a;
        this.b = b;
        this.conjunction = conjunction;
    }

    public int getSize() {
        if(s == null) {
            return a.getSize() + b.getSize();
        } else {
            return 1;
        }
    }

    public List<String> getLabels() {
        List<String> labels;
        if(s == null) {
            labels = a.getLabels();
            labels.addAll(b.getLabels());
            return labels;
        }
        return Collections.singletonList(sLabel);
    }

    public FuzzySet getFuzzySet() {
        if (fuzzySet == null) {
            if (b == null) {
                fuzzySet = new FuzzySet(s.membershipFunctions.get(sLabel));
                for(float f : values) {
                    fuzzySet.addValue(f);
                }
            } else {
                fuzzySet = new FuzzySet();
                if(conjunction == Conjunctions.AND) {
                    for(float f : values) {
                        fuzzySet.addValue(f, Math.min(a.fuzzySet.getMembership(f), b.fuzzySet.getMembership(f)));
                    }
                } else {
                    for(float f : values) {
                        fuzzySet.addValue(f, Math.max(a.fuzzySet.getMembership(f), b.fuzzySet.getMembership(f)));
                    }
                }

            }
        }
        return fuzzySet;
    }

    @Override
    public String toString() {
        if(s == null) {
            if(conjunction == Conjunctions.AND) {
                return a.toString() + " i " + b.toString();
            } else {
                return a.toString() + " lub " + b.toString();
            }
        }
        return sLabel;
    }
}
