package model.sentences;

import lombok.Getter;
import model.FuzzySet;
import model.linguistic_quantifiers.LinguisticQuantifier;

import java.util.List;

public class KSentence {
    private LinguisticQuantifier linguisticQuantifier;
    @Getter
    private List<FuzzySet> sFuzzySets;
    @Getter
    private List<FuzzySet> wFuzzySets;

    public LinguisticQuantifier getQ() {
        return linguisticQuantifier;
    }

    public float getCombinedSWCardinality() {
        return 0;
    }

    public float getCombinedWCardinality() {
        return 0;
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
