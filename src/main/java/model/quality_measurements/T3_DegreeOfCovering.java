package model.quality_measurements;

import model.sentences.*;

public class T3_DegreeOfCovering implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        if (sentence.getType() == SentenceType.K) {
            KSentence kSentence = (KSentence) sentence;
            value = kSentence.getWSCombinedSupp() / kSentence.getWCombinedSupp();
        }
        return value;
    }
}
