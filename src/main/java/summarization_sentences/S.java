package summarization_sentences;

import helpers.Function;

import java.util.List;

/***
 * Pełni rolę summaryzatora w podsumowaniach
 */
public class S {
    private String columnID;
    private Function function;
    private String selectedWord;

    public S(String columnID, String selectedWord, Function function) {
        this.columnID = columnID;
        this.selectedWord = selectedWord;
        this.function = function;
    }

    public float calculateAffiliation(float numericValue) {
        if(function.hasWord(selectedWord)) {
            return function.getValue(selectedWord, numericValue);
        }
        return 0;
    }

    public String getColumnID() {
        return columnID;
    }

    public String getSelectedWord() {
        return selectedWord;
    }
}
