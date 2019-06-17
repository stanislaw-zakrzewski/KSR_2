package model.sentences;

import lombok.Getter;
import model.FuzzySet;
import model.linguistic_variables.LinguisticVariable;
import model.linguistic_quantifiers.LinguisticQuantifier;

import java.util.List;

public class YSentence implements Sentence {
    @Getter
    private LinguisticQuantifier q;
    @Getter
    private LinguisticVariable s;
    @Getter
    private String sLabel;
    @Getter
    private FuzzySet sFuzzySet;

    public YSentence(LinguisticQuantifier q, LinguisticVariable s, String sLabel) {
        this.q = q;
        this.s = s;
        this.sLabel = sLabel;
    }

    public void process(List<Float> x) {
        if(sFuzzySet == null) {
            sFuzzySet = new FuzzySet(s.getMembershipFunctionForLabel(sLabel));
            for(Float f : x) {
                sFuzzySet.addValue(f);
            }
        }
    }

    @Override
    public SentenceType getType() {
        return SentenceType.Y;
    }

    @Override
    public String toString() {
        String sentence = q.getName();
        if(q.isAbsolute()) {
            sentence += " "  + q.getValue();
        }
        return sentence + " lotów jest " + sLabel;
    }
}
