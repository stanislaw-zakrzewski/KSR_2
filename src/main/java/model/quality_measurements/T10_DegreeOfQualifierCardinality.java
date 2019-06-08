package model.quality_measurements;

import model.FuzzySet;
import model.sentences.*;

public class T10_DegreeOfQualifierCardinality implements QualityMeasurement{

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        if (sentence.getType() == SentenceType.K) {
            KSentence kSentence = (KSentence) sentence;
            value = 1;
            for (FuzzySet fs : kSentence.getWFuzzySets()) {
                value *= (fs.getCardinality() / fs.getSize());
            }
            value = 1 - (float) Math.pow(value, 1 / kSentence.getWFuzzySets().size());
        }
        return value;
    }
}
