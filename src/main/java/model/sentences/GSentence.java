package model.sentences;

import lombok.Getter;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.CombinationLinguisticVariable;

import java.util.List;

public class GSentence implements Sentence{
    @Getter
    private LinguisticQuantifier q;
    @Getter
    private CombinationLinguisticVariable s;

    public void process(List<Float> x) {
        s.setValues(x);
        s.getFuzzySet();
    }

    public float getCombinedSCardinality() {
        return s.getFuzzySet().getCardinality();
    }

    public float getSSize() {
        return s.getFuzzySet().getSize();
    }

    @Override
    public SentenceType getType() {
        return SentenceType.G;
    }

    @Override
    public String toString() {
        return q.getName() + " lotów jest " + s.toString();
    }
}
