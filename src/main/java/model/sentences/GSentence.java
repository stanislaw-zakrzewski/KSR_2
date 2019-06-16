package model.sentences;

import lombok.Getter;
import model.FuzzySet;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.CombinationLinguisticVariable;

import java.util.List;

public class GSentence implements Sentence{
    @Getter
    private LinguisticQuantifier q;
    @Getter
    private CombinationLinguisticVariable s;

    public GSentence(LinguisticQuantifier q, CombinationLinguisticVariable s) {
        this.q = q;
        this.s = s;
    }

    public void process(List<Float> x) {
        s.setValues(x);
        s.getFuzzySet();
    }

    public List<FuzzySet> getSFuzzySets() {
        return s.getFuzzySets();
    }

    public float getCombinedSCardinality() {
        return s.getFuzzySet().getCardinality();
    }

    public float getSSize() {
        return s.getSSize();
    }

    @Override
    public SentenceType getType() {
        return SentenceType.G;
    }

    @Override
    public String toString() {
        String sentence = q.getName();
        if(q.isAbsolute()) {
            sentence += " "  + q.getValue();
        }
        return sentence + " lotów jest " + s.toString();
    }
}
