package model.quality_measurements;

import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;

public class T5_DegreeOfSummarizersCount implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 1;
        switch (sentence.getType()) {
            case G:
                GSentence gSentence = (GSentence) sentence;
                value = 2 * (float) Math.pow(.5f, gSentence.getSFuzzySets().size());
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                value = 2 * (float) Math.pow(.5f, kSentence.getSFuzzySets().size());
                break;
        }
        return value;
    }
}
