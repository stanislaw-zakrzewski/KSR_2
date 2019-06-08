package model.quality_measurements;

import model.FuzzySet;
import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.Sentence;
import model.sentences.YSentence;

public class T2_DegreeOfImprecision implements QualityMeasurement {

    @Override
    public float calculateValue(Sentence sentence) {
        float value = 0;
        switch (sentence.getType()) {
            case Y:
                YSentence ySentence = (YSentence)sentence;
                value = 1 - (ySentence.getSSupp()/ySentence.getSSize());
                break;
            case G:
                GSentence gSentence = (GSentence)sentence;
                value = 1;
                for(FuzzySet set : gSentence.getSFuzzySets()) {
                    value*=(set.getSupp()/set.getSize());
                }
                value = (float) (1- Math.pow(value, (1.0f/gSentence.getSFuzzySets().size())));
                break;
            case K:
                KSentence kSentence = (KSentence)sentence;
                value = 1;
                for(FuzzySet set : kSentence.getSFuzzySets()) {
                    value*=(set.getSupp()/set.getSize());
                }
                value = (float) (1- Math.pow(value, (1.0f/kSentence.getSFuzzySets().size())));
                break;
        }
        return value;
    }
}
