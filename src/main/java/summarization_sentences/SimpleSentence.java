package summarization_sentences;

import db.ConnectionDB;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleSentence {
    private DegreeOfMembership degreeOfMembership;
    private P p;
    private S s;
    private List<Float> values;

    public SimpleSentence(DegreeOfMembership degreeOfMembership, P p, S s) {
        this.degreeOfMembership = degreeOfMembership;
        this.p = p;
        this.s = s;
        values = new ArrayList<>();
    }

    public void CalculateValues() {
        try {
            Statement st = ConnectionDB.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select " + s.getColumnID() + " from flights where " + p.getColumnID() + "=\'" + p.getValue() + "\';");
            while (rs.next()) {
                values.add(s.calculateAffiliation(rs.getFloat(s.getColumnID())));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public float finalValue() {
        float[] values2 = ArrayUtils.toPrimitive(values.toArray(new Float[0]), 0.0F);
        Arrays.sort(values2);
        int ret = 0;

        for (float v : values2) {
            ret += v;
        }
        float f = degreeOfMembership.getValue((float) ret / (float) values2.length);
        return f;
    }
}
