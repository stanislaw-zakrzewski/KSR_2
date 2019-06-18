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

    public KSentence(LinguisticQuantifier q, CombinationLinguisticVariable s, CombinationLinguisticVariable w) {
        this.q = q;
        this.s = s;
        this.w = w;
    }

    public float getCombinedSWCardinality() {
        float value = 0;
        for (int i = 0; i < s.getFuzzySet().getMemberships().size(); i++) {
            value += Math.min(s.getFuzzySet().getMembershipForElement(i), w.getFuzzySet().getMembershipForElement(i));
        }
        return value;
    }

    public float getCombinedWCardinality() {
        return s.getFuzzySet().getCardinality();
    }

    public float getWSCombinedSupp() {
        float value = 0;
        for (int i = 0; i < s.getFuzzySet().getSize(); i++) {
            if (s.getFuzzySet().getMembershipForElement(i) > 0 && w.getFuzzySet().getMembershipForElement(i) > 0)
                value += 1;
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
        String sentence = q.getName();
        if (q.isAbsolute()) {
            sentence += " " + q.getValue();
        }
        return sentence + " lotów, które są " + w.toString() + " jest " + s.toString();
    }


}
