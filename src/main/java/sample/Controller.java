package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.LinguisticVariable;
import model.sentences.GSentence;
import model.sentences.YSentence;
import sentence_generation.GSentenceGenerator;
import sentence_generation.MeasuringQualityOfSentences;
import sentence_generation.YSentenceGenerator;
import sentence_building_blocks.linguistic_variables.AllLinguisticVariables;
import sentence_building_blocks.qualifiers.AllLinguisticQuantifiers;

import java.net.URL;
import java.util.Arrays;
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
    private List<CheckBox> selectedQualityMeasurements;

    @FXML
    public ListView<String> qListView, wListView, sListView;

    @FXML
    public TableView<ViewSentence> viewSentences;
    public TableColumn<ViewSentence, String> sentence;
    public TableColumn<ViewSentence, Float> accuracy;

    @FXML
    public CheckBox t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedQualityMeasurements = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11);
        //selectedQualityMeasurements.forEach(qm -> qm.setSelected(true));

        sentence.setCellValueFactory(new PropertyValueFactory<>("sentence"));
        accuracy.setCellValueFactory(new PropertyValueFactory<>("accuracy"));

        for(LinguisticQuantifier lq : allLinguisticQuantifiers.getLinguisticQuantifiers()) {
            qListView.getItems().add(lq.getName());
        }

        for(LinguisticVariable lv : allLinguisticVariables.getLinguisticVariables()) {
            sListView.getItems().add(lv.getName());
        }
        setObserver(qListView, selectedLinguisticQuantifiers);

        wListView.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) ->
                    System.out.println("LinguisticQuantifier check box for "+item+" changed from "+wasSelected+" to "+isNowSelected)
            );
            return observable ;
        }));

        setObserver(sListView, selectedLinguisticVariables);
    }

    public void getSentence() {
        data.clear();

        List<LinguisticQuantifier> qList = allLinguisticQuantifiers.getLinguisticQuantifiers().stream().filter(q -> selectedLinguisticQuantifiers.contains(q.getName())).collect(Collectors.toList());
        List<LinguisticVariable> sList = allLinguisticVariables.getLinguisticVariables().stream().filter(s -> selectedLinguisticVariables.contains(s.getName())).collect(Collectors.toList());

        List<YSentence> ySentences = YSentenceGenerator.generateSentences(qList,sList);
        List<GSentence> gSentences = GSentenceGenerator.generateSentences(qList, sList);

        List<Boolean> selectedMeasurements = selectedQualityMeasurements.stream().map(CheckBox::isSelected).collect(Collectors.toList());
        MeasuringQualityOfSentences measuringQualityOfSentences = new MeasuringQualityOfSentences(selectedMeasurements);

        for(YSentence ySentence : ySentences) {
            data.add(new ViewSentence(ySentence.toString(), measuringQualityOfSentences.calculateQuality(ySentence)));
        }
        for(GSentence gSentence : gSentences) {
            data.add(new ViewSentence(gSentence.toString(), measuringQualityOfSentences.calculateQuality(gSentence)));
        }

        viewSentences.setItems(data);
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
