package summarization_sentences;

public class DegreeOfMembershipSpike implements DegreeOfMembership {
    private float point;
    private float width;

    public DegreeOfMembershipSpike(float point, float width) {
        this.point = point;
        this.width = width;
    }

    @Override
    public float getValue(float x) {
        if (x >= point - width / 2 && x <= point + width / 2) {
            return 1.0f - Math.abs(point - x) / width * 2.0f;
        } else {
            return 0;
        }
    }
}
