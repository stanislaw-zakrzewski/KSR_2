package helpers;

import java.util.Arrays;
import java.util.List;

public class DelayFunction implements Function {
    private List<String> words;

    public DelayFunction() {
        words = Arrays.asList("na czas","spóźnione","bardzo spóźnione");
    }

    @Override
    public boolean hasWord(String word) {
        return words.contains(word);
    }

    @Override
    public float getValue(String word, float value) {
        switch (word) {
            case "na czas":
                if(value < 15) return 1;
                break;
            case "spóźnione":
                if(value >= 15 && value < 100) return 1;
                break;
            case "bardzo spóźnione":
                if(value > 100) return 1;
                break;
        }
        return 0;
    }
}
