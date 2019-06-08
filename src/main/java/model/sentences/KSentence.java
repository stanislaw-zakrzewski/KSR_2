package model.sentences;

import lombok.Getter;
import model.FuzzySet;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.CombinationLinguisticVariable;

import java.util.List;

public class KSentence implements Sentence {
    @Getter
    private LinguisticQuantifier q;
    @Getter
    private CombinationLinguisticVariable s;
    @Getter
    private CombinationLinguisticVariable w;


    public float getCombinedSWCardinality() {
        float value = 0;
        for (Float f : s.getFuzzySet().getValues()) {
            value += Math.min(s.getFuzzySet().getMembership(f), w.getFuzzySet().getMembership(f));
        }
        return value;
    }

    public float getCombinedWCardinality() {
        return s.getFuzzySet().getCardinality();
    }

    public float getWSCombinedSupp() {
        float value = 0;
        for (Float f : s.getFuzzySet().getValues()) {
            if (s.getFuzzySet().getMembership(f) > 0 && w.getFuzzySet().getMembership(f) > 0) value += 1;
        }
        return value;
    }

    public float getWCombinedSupp() {
        return w.getFuzzySet().getSupp();
    }

    public List<FuzzySet> getWFuzzySets() {
        return w.getFuzzySets();
    }

    public List<FuzzySet> getSFuzzySets() {
        return s.getFuzzySets();
    }

    @Override
    public SentenceType getType() {
        return SentenceType.K;
    }

    @Override
    public String toString() {
        return q.getName() + " lotów będących " + w.toString() + " jest " + s.toString();
    }


}
