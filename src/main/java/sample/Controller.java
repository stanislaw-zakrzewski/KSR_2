package sample;

import db.ConnectionDB;
import helpers.DelayFunction;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.qualifiers.Qualifier;
import model.sentences.Sentence;
import model.sentences.YSentence;
import sentence_building_blocks.linguistic_quantifiers.LinguisticQuantifierExample;
import sentence_building_blocks.qualifiers.QualifierExample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Controller implements Initializable {
    private final ObservableList<ViewSentence> data = FXCollections.observableArrayList();

    ObservableList<String> qList;
    ObservableList<String> pList;
    ObservableList<String> sList;

    @FXML
    public ComboBox<String> qComboBox;
    @FXML
    public ComboBox<String> pComboBox;
    @FXML
    public ComboBox<String> sComboBox;

    @FXML
    public TableView<ViewSentence> sentences;
    public TableColumn<ViewSentence, String> sentence;
    public TableColumn<ViewSentence, Float> accuracy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        qList = FXCollections.observableArrayList("mało", "dużo");

        pList = FXCollections.observableArrayList();
        try {
            Statement st = ConnectionDB.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select distinct origin_state_name from flights;");
            pList.add("------");
            while (rs.next()) {
                pList.add(rs.getString("origin_state_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sList = FXCollections.observableArrayList("na czas", "spóźniony", "bardzo spóźniony");

        qComboBox.setValue("mało");
        qComboBox.setItems(qList);
        pComboBox.setValue("------");
        pComboBox.setItems(pList);
        sComboBox.setValue("na czas");
        sComboBox.setItems(sList);

        sentence.setCellValueFactory(new PropertyValueFactory<>("sentence"));
        accuracy.setCellValueFactory(new PropertyValueFactory<>("accuracy"));
    }

    public void getSentence() {
        Qualifier q = new QualifierExample();
        LinguisticQuantifier s = new LinguisticQuantifierExample();
        Sentence ySentence = new YSentence();

        data.clear();

        List<String> H = Arrays.asList("mało", "dużo");
        Map<String, DegreeOfMembership> M = new HashMap<>();
        M.put(H.get(0), new DegreeOfMembershipSpike(0.3f, 0.6f));
        M.put(H.get(1), new DegreeOfMembershipSpike(0.7f, 0.6f));
        q = new Q("jak dużo", H, M);

        s = new S("dep_delay", sComboBox.getValue(), new DelayFunction());

        if (pComboBox.getValue().equals("------")) {
            for (int i = 1; i < pList.size(); i++) {
                p = new P("origin_state_name", pList.get(i));
                simpleSentence = new SimpleSentence(q.getM().get(qComboBox.getValue()), p, s);
                simpleSentence.CalculateValues();
                data.add(new ViewSentence(qComboBox.getValue() + " lotów do " + p.getValue() + " było " + s.getSelectedWord(), simpleSentence.finalValue()));
            }
        } else {
            p = new P("origin_state_name", pComboBox.getValue());
            simpleSentence = new SimpleSentence(q.getM().get(qComboBox.getValue()), p, s);
            simpleSentence.CalculateValues();
            data.add(new ViewSentence(qComboBox.getValue() + " lotów do " + p.getValue() + " było " + s.getSelectedWord(), simpleSentence.finalValue()));
        }
        sentences.setItems(data);
    }

    public static class ViewSentence {
        private final SimpleStringProperty sentence;
        private final SimpleFloatProperty accuracy;

        private ViewSentence(String sentence, float accuracy) {
            this.sentence = new SimpleStringProperty(sentence);
            this.accuracy = new SimpleFloatProperty(accuracy);
        }

        public String getSentence() {
            return sentence.get();
        }

        public void setSentence(String newSentence) {
            sentence.set(newSentence);
        }

        public float getAccuracy() {
            return accuracy.floatValue();
        }

        public void setAccuracy(float newAccuracy) {
            accuracy.set(newAccuracy);
        }
    }
}
