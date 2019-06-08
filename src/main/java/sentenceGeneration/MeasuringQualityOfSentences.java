package sentenceGeneration;

import model.quality_measurements.*;
import model.sentences.Sentence;
import model.sentences.SentenceType;

import java.util.LinkedList;
import java.util.List;

public class MeasuringQualityOfSentences {
    private List<QualityMeasurement> type1Measurements;
    private List<QualityMeasurement> type2Measurements;

    public MeasuringQualityOfSentences(List<Boolean> selectedMeasurements) {
        type1Measurements = new LinkedList<>();
        type2Measurements = new LinkedList<>();
        QualityMeasurement pom;
        if (selectedMeasurements.get(0)) {
            pom = new T1_DegreeOfTruth();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(1)) {
            pom = new T2_DegreeOfImprecision();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(2)) type2Measurements.add(new T3_DegreeOfCovering());

        if (selectedMeasurements.get(3)) {
            pom = new T4_DegreeOfAppropriatness();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(4)) {
            pom = new T5_DegreeOfSummarizersCount();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(5)) {
            pom = new T6_DegreeOfQuantifierImprecision();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(6)) {
            pom = new T7_DegreeOfQuantifierCardinality();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(7)) {
            pom = new T8_DegreeOfSummarizerCardinality();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
        }
        if (selectedMeasurements.get(8)) type2Measurements.add(new T9_DegreeOfQualifierImprecision());

        if (selectedMeasurements.get(9)) type2Measurements.add(new T10_DegreeOfQualifierCardinality());

        if (selectedMeasurements.get(10)) type2Measurements.add(new T11_DegreeOfQualifierCount());
    }

    public float calculateQuality(Sentence sentence) {
        float quality = 0;
        if(sentence.getType().equals(SentenceType.K)) {
            for(QualityMeasurement qm : type2Measurements) {
                quality += qm.calculateValue(sentence);
            }
            quality/= type2Measurements.size();
        } else {
            for(QualityMeasurement qm : type1Measurements) {
                quality += qm.calculateValue(sentence);
            }
            quality/= type1Measurements.size();
        }
        return quality;
    }
}
