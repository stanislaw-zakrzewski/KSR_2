package model.quality_measurements;

import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T1_DegreeOfTruth implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence) sentence;
                value = ySentence.getQ().calculateMembership(ySentence.getSFuzzySet().getCardinality() / ySentence.getSFuzzySet().getSize());
                break;
            case G:
                GSentence gSentence = (GSentence) sentence;
                value = gSentence.getQ().calculateMembership(gSentence.getCombinedSCardinality() / gSentence.getSSize());
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                value = kSentence.getQ().calculateMembership(kSentence.getCombinedSWCardinality() / kSentence.getCombinedWCardinality());
                break;
        }
        return value;
    }
}
