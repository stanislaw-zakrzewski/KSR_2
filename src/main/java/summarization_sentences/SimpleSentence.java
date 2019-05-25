package summarization_sentences;

import db.ConnectionDB;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleSentence {
    private Q q;
    private P p;
    private S s;
    private List<Float> values;

    public SimpleSentence(Q q, P p, S s) {
        this.q = q;
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
        int size = (int) (values2.length * q.getProportion());
        int ret = 0;

        for(int i = 0; i < values2.length; i++) {
            if(i < values2.length - size) {
                ret += 1 - values2[i];
            }
            else {
                ret += values2[i];
            }
        }
        return (float)ret / (float)values2.length;
    }
}
