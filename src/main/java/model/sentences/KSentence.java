package model.sentences;

import model.FuzzySet;
import model.linguistic_quantifiers.LinguisticQuantifier;

import java.util.List;

public class KSentence {
    private LinguisticQuantifier linguisticQuantifier;
    private List<FuzzySet> sFuzzySets;

    public LinguisticQuantifier getQ() {
        return linguisticQuantifier;
    }

    public float getCombinedSWCardinality() {
        return 0;
    }

    public float getCombinedWCardinality() {
        return 0;
    }

    public List<FuzzySet> getSFuzzySets() {
        return sFuzzySets;
    }

    public float getWSCombinedSupp() {
        return 0;
    }

    public float getWCombinedSupp() {
        return 0;
    }

    public float getQSize() {
        return 0;
    }

    public int getQSupp() {
        return 0;
    }
}
