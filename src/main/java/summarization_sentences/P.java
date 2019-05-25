package summarization_sentences;

/***
 * Pełni rolę podmiotu zdania w podsumowaniach
 */
public class P {
    private String value;
    private String columnID;

    public P(String columnID, String value) {
        this.columnID = columnID;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getColumnID() {
        return columnID;
    }
}
