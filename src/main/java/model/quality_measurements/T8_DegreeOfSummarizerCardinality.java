package model.quality_measurements;

import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T8_DegreeOfSummarizerCardinality implements QualityMeasurement{

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence)sentence;
                value = 1 - (ySentence.getSCardinality()/ySentence.getSSize());
                break;
            case K:
                KSentence kSentence = (KSentence)sentence;
                break;
            case G:
                GSentence gSentence = (GSentence)sentence;
                break;
        }
        return value;
    }
}
