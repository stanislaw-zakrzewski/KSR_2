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
                value -= (ySentence.getSFuzzySet().getMembershipFunction().getIntegralValue() / ySentence.getSFuzzySet().getMembershipFunction().getRange());
                break;
            case G:
                GSentence gSentence = (GSentence) sentence;
                for (FuzzySet fs : gSentence.getSFuzzySets()) {
                    value *= (fs.getMembershipFunction().getIntegralValue() / fs.getMembershipFunction().getRange());
                }
                value = 1 - (float) Math.pow(value, 1.f / gSentence.getSFuzzySets().size());
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                for (FuzzySet fs : kSentence.getSFuzzySets()) {
                    value *= (fs.getMembershipFunction().getIntegralValue() / fs.getMembershipFunction().getRange());
                }
                value = 1 - (float) Math.pow(value, 1.f / kSentence.getSFuzzySets().size());
                break;
        }
        return value;
    }
}
