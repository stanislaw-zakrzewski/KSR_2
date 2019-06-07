package sample;

import db.ConnectionDB;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.LinguisticVariable;
import model.quality_measurements.T1_DegreeOfTruth;
import model.sentences.YSentence;
import sentence_building_blocks.linguistic_variables.AllLinguisticVariables;
import sentence_building_blocks.qualifiers.AllLinguisticQuantifiers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    private final ObservableList<ViewSentence> data = FXCollections.observableArrayList();

    private AllLinguisticQuantifiers allLinguisticQuantifiers = new AllLinguisticQuantifiers();
    private AllLinguisticVariables allLinguisticVariables = new AllLinguisticVariables();

    private List<String> selectedLinguisticQuantifiers = new LinkedList<>();
    private List<String> selectedLinguisticVariables = new LinkedList<>();

    @FXML
    public ListView<String> qListView;
    @FXML
    public ListView<String> wListView;
    @FXML
    public ListView<String> sListView;

    @FXML
    public TableView<ViewSentence> sentences;
    public TableColumn<ViewSentence, String> sentence;
    public TableColumn<ViewSentence, Float> accuracy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        sentence.setCellValueFactory(new PropertyValueFactory<>("sentence"));
        accuracy.setCellValueFactory(new PropertyValueFactory<>("accuracy"));

        for(LinguisticQuantifier lq : allLinguisticQuantifiers.getLinguisticQuantifiers()) {
            qListView.getItems().add(lq.getName());
        }

        for(LinguisticVariable lv : allLinguisticVariables.getLinguisticVariables()) {
            sListView.getItems().add(lv.getName());
        }
        setObserver(qListView, selectedLinguisticQuantifiers);

        wListView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(String item) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected) ->
                        System.out.println("LinguisticQuantifier check box for "+item+" changed from "+wasSelected+" to "+isNowSelected)
                );
                return observable ;
            }
        }));

        setObserver(sListView, selectedLinguisticVariables);
    }

    public void getSentence() {
        data.clear();

        for(LinguisticQuantifier q : allLinguisticQuantifiers.getLinguisticQuantifiers().stream().filter(q -> selectedLinguisticQuantifiers.contains(q.getName())).collect(Collectors.toList())) {
            for(LinguisticVariable s : allLinguisticVariables.getLinguisticVariables().stream().filter(s -> selectedLinguisticVariables.contains(s.getName())).collect(Collectors.toList())) {
                for(String label : s.getLabels()) {
                    YSentence ySentence = new YSentence(q,s,label);

                    List<Float> x = new LinkedList<>();

                    try {
                        Statement st = ConnectionDB.getConnection().createStatement();
                        ResultSet rs = st.executeQuery("select " + s.getColumn() + " from flights");
                        while (rs.next()) {
                            x.add(rs.getFloat(s.getColumn()));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    ySentence.process(x);


                    T1_DegreeOfTruth degreeOfTruth = new T1_DegreeOfTruth();
                    data.add(new ViewSentence(ySentence.toString(), degreeOfTruth.calculateValue(ySentence)));
                }
            }
        }
        sentences.setItems(data);
    }

    private void setObserver(ListView<String> listView, List<String> selectedItems) {
        listView.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) ->
                    {
                        if(isNowSelected) {
                            selectedItems.add(item);
                        } else {
                            selectedItems.remove(item);
                        }
                    }
            );
            return observable ;
        }));
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
