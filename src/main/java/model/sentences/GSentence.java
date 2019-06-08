package model.sentences;

import model.FuzzySet;
import model.linguistic_quantifiers.LinguisticQuantifier;

import java.util.List;

public class GSentence {
    private LinguisticQuantifier linguisticQuantifier;
    private List<FuzzySet> sFuzzySets;

    public LinguisticQuantifier getQ() {
        return linguisticQuantifier;
    }

    public float getCombinedSCardinality() {
        return 0;
    }

    public float getSSize() {
        return 0;
    }

    public List<FuzzySet> getSFuzzySets() {
        return sFuzzySets;
    }
}
