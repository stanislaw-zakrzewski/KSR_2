package sentence_generation;

import model.quality_measurements.*;
import model.sentences.Sentence;
import model.sentences.SentenceType;

import java.util.LinkedList;
import java.util.List;

public class MeasuringQualityOfSentences {
    private List<QualityMeasurement> type1Measurements;
    private List<QualityMeasurement> type2Measurements;
    private List<Float> type1Weights;
    private List<Float> type2Weights;

    public MeasuringQualityOfSentences(List<Boolean> selectedMeasurements, List<Float> weights) {
        type1Measurements = new LinkedList<>();
        type2Measurements = new LinkedList<>();
        type1Weights = new LinkedList<>();
        type2Weights = new LinkedList<>();
        QualityMeasurement pom;
        if (selectedMeasurements.get(0)) {
            pom = new T1_DegreeOfTruth();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(0));
            type2Weights.add(weights.get(0));
        }
        if (selectedMeasurements.get(1)) {
            pom = new T2_DegreeOfImprecision();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(1));
            type2Weights.add(weights.get(1));
        }
        if (selectedMeasurements.get(2)) {
            type2Measurements.add(new T3_DegreeOfCovering());
            type2Weights.add(weights.get(2));
        }

        if (selectedMeasurements.get(3)) {
            pom = new T4_DegreeOfAppropriatness();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(3));
            type2Weights.add(weights.get(4));
        }
        if (selectedMeasurements.get(4)) {
            pom = new T5_DegreeOfSummarizersCount();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(4));
            type2Weights.add(weights.get(4));
        }
        if (selectedMeasurements.get(5)) {
            pom = new T6_DegreeOfQuantifierImprecision();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(5));
            type2Weights.add(weights.get(5));
        }
        if (selectedMeasurements.get(6)) {
            pom = new T7_DegreeOfQuantifierCardinality();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(6));
            type2Weights.add(weights.get(6));
        }
        if (selectedMeasurements.get(7)) {
            pom = new T8_DegreeOfSummarizerCardinality();
            type1Measurements.add(pom);
            type2Measurements.add(pom);
            type1Weights.add(weights.get(7));
            type2Weights.add(weights.get(7));
        }
        if (selectedMeasurements.get(8)) {
            type2Measurements.add(new T9_DegreeOfQualifierImprecision());
            type2Weights.add(weights.get(8));
        }

        if (selectedMeasurements.get(9)) {
            type2Measurements.add(new T10_DegreeOfQualifierCardinality());
            type2Weights.add(weights.get(9));
        }

        if (selectedMeasurements.get(10)) {
            type2Measurements.add(new T11_DegreeOfQualifierCount());
            type2Weights.add(weights.get(10));
        }
    }

    public float calculateQuality(Sentence sentence) {
        float quality = 0;
        if(sentence.getType().equals(SentenceType.K)) {
            for(int i =0; i < type2Measurements.size(); i++) {
                quality += type2Measurements.get(i).calculateValue(sentence) * type2Weights.get(i);
            }
            quality/= type2Weights.stream().reduce(0.f, Float::sum);
        } else {
            for(int i = 0; i < type1Measurements.size(); i++) {
                quality += type1Measurements.get(i).calculateValue(sentence) * type1Weights.get(i);
            }
            quality/= type1Weights.stream().reduce(0.f, Float::sum);
        }
        return quality;
    }
}
