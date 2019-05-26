package summarization_sentences;

import java.util.List;
import java.util.Map;

/***
 * Pełni rolę kwantyfikatora lingwistycznego w podsumowaniach
 */
public class Q {
    private String L;
    private List<String> H;
    private Map<String, DegreeOfMembership> M;

    public Q(String value, List<String> H, Map<String, DegreeOfMembership> M) {
        this.L = value;
        this.H = H;
        this.M = M;
    }

    public String getL() {
        return L;
    }

    public List<String> getH() {
        return H;
    }

    public Map<String, DegreeOfMembership> getM() {
        return M;
    }
}
