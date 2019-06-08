package sentenceGeneration;

import db.ConnectionDB;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.LinguisticVariable;
import model.sentences.YSentence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class YSentenceGenerator {

    public static LinkedList<YSentence> generateSentences(List<LinguisticQuantifier> qList, List<LinguisticVariable> sList) {
        LinkedList<YSentence> sentences = new LinkedList<>();
        for (LinguisticQuantifier q : qList) {
            for (LinguisticVariable s : sList) {
                for (String label : s.getLabels()) {
                    sentences.add(new YSentence(q, s, label));

                    LinkedList<Float> x = new LinkedList<>();

                    try {
                        Statement st = ConnectionDB.getConnection().createStatement();
                        ResultSet rs = st.executeQuery("select " + s.getColumn() + " from flights");
                        while (rs.next()) {
                            x.add(rs.getFloat(s.getColumn()));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    sentences.getLast().process(x);
                }
            }
        }
        return sentences;
    }
}
