package model.quality_measurements;

import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T6_DegreeOfQuantifierImprecision implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence) sentence;
                value = 1 - (ySentence.getQ().getSupp() / ySentence.getQ().getSize());
                break;
            case G:
                GSentence gSentence = (GSentence) sentence;
                value = 1 - (gSentence.getQ().getSupp() / gSentence.getQ().getSize());
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                value = 1 - (kSentence.getQ().getSupp() / kSentence.getQ().getSize());
                break;
        }
        return value;
    }
}
