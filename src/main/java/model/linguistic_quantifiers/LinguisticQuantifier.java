package model.linguistic_quantifiers;

import java.util.List;

public interface LinguisticQuantifier {
    String getName();
    List<String> getLabels();
    float calculateValueForLabel(String label);
}
