package model.quality_measurements;

import model.sentences.*;

public class T11_DegreeOfQualifierCount implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        if (sentence.getType() == SentenceType.K) {
            KSentence kSentence = (KSentence) sentence;
            value = 2 * (float) Math.pow(.5, kSentence.getWFuzzySets().size());
        }
        return value;
    }
}
