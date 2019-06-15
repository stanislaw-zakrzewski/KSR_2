package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.linguistic_quantifiers.LinguisticQuantifier;
import model.linguistic_variables.LinguisticVariable;
import model.membership_functions.MembershipFunction;
import model.sentences.GSentence;
import model.sentences.KSentence;
import model.sentences.YSentence;
import sentence_building_blocks.membership_functions.*;
import sentence_generation.GSentenceGenerator;
import sentence_generation.KSentenceGenerator;
import sentence_generation.MeasuringQualityOfSentences;
import sentence_generation.YSentenceGenerator;
import sentence_building_blocks.linguistic_variables.AllLinguisticVariables;
import sentence_building_blocks.linguistic_quantifier.AllLinguisticQuantifiers;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    private final ObservableList<ViewSentence> data = FXCollections.observableArrayList();

    private AllLinguisticQuantifiers allLinguisticQuantifiers = new AllLinguisticQuantifiers();
    private AllLinguisticVariables allLinguisticVariables = new AllLinguisticVariables();

    private List<String> selectedLinguisticQuantifiers = new LinkedList<>();
    private List<String> selectedLinguisticVariables = new LinkedList<>();
    private List<CheckBox> selectedQualityMeasurements;
    private List<TextArea> weights;

    @FXML
    public ListView<String> qListView, sListView;

    @FXML
    public ComboBox<String> nameZmienna, nameEtykieta;

    @FXML
    public TextArea fileName, w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11;
    @FXML
    public TextField a_1, a_2, a_3, a_4, a_5, a_6, b_1, b_2, b_3, b_4, b_5, b_6, c_1, c_2, c_4, d_2;

    @FXML
    public TableView<ViewSentence> viewSentences;
    public TableColumn<ViewSentence, String> sentence;
    public TableColumn<ViewSentence, String> accuracy;

    @FXML
    public CheckBox t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, typeY, typeG, typeK, f1, f2, f3, f4, f5, f6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedQualityMeasurements = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11);
        weights = Arrays.asList(w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11);

        sentence.setCellValueFactory(new PropertyValueFactory<>("sentence"));
        accuracy.setCellValueFactory(new PropertyValueFactory<>("accuracy"));

        for (LinguisticQuantifier lq : allLinguisticQuantifiers.getLinguisticQuantifiers()) {
            qListView.getItems().add(lq.getName());
        }
        for (LinguisticVariable lv : allLinguisticVariables.getLinguisticVariables()) {
            sListView.getItems().add(lv.getName());
        }
        setObserver(qListView, selectedLinguisticQuantifiers);
        setObserver(sListView, selectedLinguisticVariables);

        nameZmienna.setItems(FXCollections.observableArrayList(allLinguisticVariables.getLinguisticVariables().stream().map(LinguisticVariable::getName).collect(Collectors.toList())));
        nameZmienna.valueProperty().addListener((ov, t, name) -> nameEtykieta.setItems(FXCollections.observableArrayList(allLinguisticVariables.getLinguisticVariables().stream().filter(v -> v.getName().equals(name)).findFirst().get().getLabels())));
    }

    public void getSentence() {
        data.clear();

        List<LinguisticQuantifier> qList = allLinguisticQuantifiers.getLinguisticQuantifiers().stream().filter(q -> selectedLinguisticQuantifiers.contains(q.getName())).collect(Collectors.toList());
        List<LinguisticVariable> sList = allLinguisticVariables.getLinguisticVariables().stream().filter(s -> selectedLinguisticVariables.contains(s.getName())).collect(Collectors.toList());
        List<Boolean> selectedMeasurements = selectedQualityMeasurements.stream().map(CheckBox::isSelected).collect(Collectors.toList());
        List<Float> weightsValues = weights.stream().map(t -> Float.parseFloat(t.getText())).collect(Collectors.toList());

        MeasuringQualityOfSentences measuringQualityOfSentences = new MeasuringQualityOfSentences(selectedMeasurements, weightsValues);

        if (typeY.isSelected()) {
            for (YSentence ySentence : YSentenceGenerator.generateSentences(qList, sList)) {
                data.add(new ViewSentence(ySentence.toString(), measuringQualityOfSentences.calculateQuality(ySentence)));
            }
        }
        if (typeG.isSelected()) {
            for (GSentence gSentence : GSentenceGenerator.generateSentences(qList, sList)) {
                data.add(new ViewSentence(gSentence.toString(), measuringQualityOfSentences.calculateQuality(gSentence)));
            }
        }
        if (typeK.isSelected()) {
            for (KSentence kSentence : KSentenceGenerator.generateSentences(qList, sList)) {
                data.add(new ViewSentence(kSentence.toString(), measuringQualityOfSentences.calculateQuality(kSentence)));
            }
        }

        viewSentences.setItems(data);
    }

    public void exportTXT() {
        if (data.size() > 0) {

            try (FileWriter writer = new FileWriter(fileName.getText());
                 BufferedWriter bw = new BufferedWriter(writer)) {

                for (ViewSentence viewSentence : data) {
                    bw.write("[" + String.format("%.3f", viewSentence.accuracy.getValue()) + "]\t " + viewSentence.sentence.getValue() + "\n");
                }

            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
    }

    public void changeFunction() {
        MembershipFunction membershipFunction = null;
        if (f1.isSelected()) {
            membershipFunction = new MembershipFunctionTriangular(Float.parseFloat(a_1.getText()), Float.parseFloat(b_1.getText()), Float.parseFloat(c_1.getText()));
        }
        if (f2.isSelected()) {
            membershipFunction = new MembershipFunctionTrapezoidal(Float.parseFloat(a_2.getText()), Float.parseFloat(b_2.getText()), Float.parseFloat(c_2.getText()), Float.parseFloat(d_2.getText()));
        }
        if (f3.isSelected()) {
            membershipFunction = new MembershipFunctionGaussian(Float.parseFloat(a_3.getText()), Float.parseFloat(b_3.getText()));
        }
        if (f4.isSelected()) {
            membershipFunction = new MembershipFunctionBellShape(Float.parseFloat(a_4.getText()), Float.parseFloat(b_4.getText()), Float.parseFloat(c_4.getText()));
        }
        if (f5.isSelected()) {
            membershipFunction = new MembershipFunctionGammaClass(Float.parseFloat(a_5.getText()), Float.parseFloat(b_5.getText()));
        }
        if (f6.isSelected()) {
            membershipFunction = new MembershipFunctionSClass(Float.parseFloat(a_6.getText()), Float.parseFloat(b_6.getText()));
        }
        if (membershipFunction != null) {
            setFunction(membershipFunction);
        }
    }

    private void setFunction(MembershipFunction membershipFunction) {
        Optional<LinguisticVariable> lv = allLinguisticVariables.getLinguisticVariables().stream().filter(v -> v.getName().equals(nameZmienna.getSelectionModel().getSelectedItem())).findFirst();
        if (lv.isPresent()) {
            String l = nameEtykieta.getSelectionModel().getSelectedItem();
            if (lv.get().getLabels().contains(l)) {
                lv.get().setMembershipFunction(l, membershipFunction);
            }
        }
    }

    private void setObserver(ListView<String> listView, List<String> selectedItems) {
        listView.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener((obs, wasSelected, isNowSelected) ->
                    {
                        if (isNowSelected) {
                            selectedItems.add(item);
                        } else {
                            selectedItems.remove(item);
                        }
                    }
            );
            return observable;
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

        public String getAccuracy() {
            return String.format("%.3f", accuracy.floatValue());
        }

        public void setAccuracy(float newAccuracy) {
            accuracy.set(newAccuracy);
        }
    }

    public void wybierzFunkcje() {

    }
}
