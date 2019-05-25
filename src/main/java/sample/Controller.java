package sample;

import db.ConnectionDB;
import helpers.DelayFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import summarization_sentences.P;
import summarization_sentences.Q;
import summarization_sentences.S;
import summarization_sentences.SimpleSentence;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ComboBox<String> qComboBox;
    @FXML
    public ComboBox<String> pComboBox;
    @FXML
    public ComboBox<String> sComboBox;

    @FXML
    public Label sentence;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> qList = FXCollections.observableArrayList("mało", "dużo");

        ObservableList<String> pList = FXCollections.observableArrayList();
        try {
            Statement st = ConnectionDB.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select distinct origin_state_name from flights;");
            while (rs.next()) {
                pList.add(rs.getString("origin_state_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<String> sList = FXCollections.observableArrayList("na czas", "spóźniony", "bardzo spóźniony");

        qComboBox.setValue("Select value");
        qComboBox.setItems(qList);
        pComboBox.setValue("Select value");
        pComboBox.setItems(pList);
        sComboBox.setValue("Select value");
        sComboBox.setItems(sList);
    }

    public void getSentence() {
        Q q = null;
        switch(qComboBox.getValue()) {
            case "mało":
                q = new Q("mało", 0.3f);
                break;
            case "dużo":
                q = new Q("dużo", 0.7f);
                break;
        }
        P p = new P("origin_state_name", pComboBox.getValue());
        S s = new S("dep_delay", sComboBox.getValue(), new DelayFunction());
        SimpleSentence simpleSentence = new SimpleSentence(q,p,s);
        simpleSentence.CalculateValues();
        assert q != null;
        sentence.setText(q.getValue() + " lotów do " + p.getValue() + " było " + s.getSelectedWord() + ".     [" + simpleSentence.finalValue() + "]");
    }
}
