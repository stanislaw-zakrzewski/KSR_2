package model.quality_measurements;

import model.FuzzySet;
import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T8_DegreeOfSummarizerCardinality implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 1;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence) sentence;
                value -= (ySentence.getSCardinality() / ySentence.getSSize());
                break;
            case G:
                GSentence gSentence = (GSentence) sentence;
                for (FuzzySet fs : gSentence.getSFuzzySets()) {
                    value *= (fs.getCardinality() / fs.getSize());
                }
                value = 1 - (float)Math.pow(value, 1/gSentence.getSFuzzySets().size());
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                for (FuzzySet fs : kSentence.getSFuzzySets()) {
                    value *= (fs.getCardinality() / fs.getSize());
                }
                value = 1 - (float)Math.pow(value, 1/kSentence.getSFuzzySets().size());
                break;
        }
        return value;
    }
}
