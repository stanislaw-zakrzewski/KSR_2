package model.sentences;

import model.linguistic_quantifiers.LinguisticQuantifier;
import model.qualifiers.Qualifier;

public class YSentence implements Sentence {
    private Qualifier q;
    private LinguisticQuantifier s;

    public Qualifier getQ() {
        return q;
    }

    public void setQ(Qualifier q) {
        this.q = q;
    }

    public LinguisticQuantifier getS() {
        return s;
    }

    public void setS(LinguisticQuantifier s) {
        this.s = s;
    }

    @Override
    public SentenceType getType() {
        return SentenceType.Y;
    }

    @Override
    public String toString() {
        return "";
    }
}
