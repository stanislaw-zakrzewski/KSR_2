package summarization_sentences;

/***
 * Pełni rolę kwantyfikatora lingwistycznego w podsumowaniach
 */
public class Q {
    private String value;
    private float proportion;

    public Q(String value, float proportion) {
        this.value = value;
        this.proportion = proportion;
    }

    public String getValue() {
        return value;
    }

    public float getProportion() {
        return proportion;
    }
}
