package model.quality_measurements;

import model.sentences.Sentence;

public interface QualityMeasurement {
    float calculateValue(Sentence sentence);
}
