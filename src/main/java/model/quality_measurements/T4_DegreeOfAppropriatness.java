package model.quality_measurements;

import model.FuzzySet;
import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T4_DegreeOfAppropriatness implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence) sentence;
                value = (ySentence.getSFuzzySet().getSupp() / ySentence.getSFuzzySet().getSize());
                break;
            case G:
                GSentence gSentence = (GSentence) sentence;
                value = 1;
                for (FuzzySet fs : gSentence.getSFuzzySets()) {
                    value *= (fs.getSupp() / fs.getSize());
                }
                break;
            case K:
                KSentence kSentence = (KSentence) sentence;
                value = 1;
                for (FuzzySet fs : kSentence.getSFuzzySets()) {
                    value *= (fs.getSupp() / fs.getSize());
                }
                value = Math.abs(value - kSentence.getWSCombinedSupp() / kSentence.getWCombinedSupp());
                break;
        }
        return value;
    }
}
