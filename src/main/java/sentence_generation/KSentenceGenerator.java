package sentence_generation;

import db.ConnectionDB;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.CombinationLinguisticVariable;
import model.linguistic_variables.LinguisticVariable;
import model.sentences.KSentence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import java.sql.Statement;

public class KSentenceGenerator {

    public static LinkedList<KSentence> generateSentences(List<LinguisticQuantifier> qList, List<LinguisticVariable> sList) {
        LinkedList<KSentence> sentences = new LinkedList<>();
        if (sList.size() > 1) {
            Statement st = null;
            try {
                st = ConnectionDB.getConnection().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < sList.size(); i++) {
                LinguisticVariable lv1 = sList.get(i);
                for (int j = i + 1; j < sList.size(); j++) {
                    LinguisticVariable lv2 = sList.get(j);
                    if (lv1.equals(lv2)) continue;
                    LinkedList<Float> x1 = new LinkedList<>();
                    LinkedList<Float> x2 = new LinkedList<>();
                    try {
                        assert st != null;
                        ResultSet rs = st.executeQuery("select " + lv2.getColumn() + ", " + lv1.getColumn() + " from flights");
                        while (rs.next()) {
                            x1.add(rs.getFloat(lv1.getColumn()));
                            x2.add(rs.getFloat(lv2.getColumn()));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    for (LinguisticQuantifier lq : qList) {
                        for (String label1 : lv1.getLabels()) {
                            for (String label2 : lv2.getLabels()) {
                                CombinationLinguisticVariable clv1 = new CombinationLinguisticVariable(lv1, label1);
                                clv1.process(x1);
                                CombinationLinguisticVariable clv2 = new CombinationLinguisticVariable(lv2, label2);
                                clv2.process(x2);
                                sentences.add(new KSentence(lq, clv1, clv2));
                            }
                        }
                    }
                }
            }

        }
        return sentences;
    }
}
