package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collector;


public class Exam {


    @FXML
    private Label x;

    @FXML
    private Label q1;

    @FXML
    private ComboBox<String> r1;

    @FXML
    private Label q2;

    @FXML
    private ComboBox<String> r2;

    @FXML
    private Label q3;

    @FXML
    private ComboBox<String> r3;

    @FXML
    private Label q4;

    @FXML
    private ComboBox<String> r4;

    @FXML
    private Label q5;

    @FXML
    private ComboBox<String> r5;

    @FXML
    private Label q6;

    @FXML
    private ComboBox<String> r6;


    public void bouttIn(MouseEvent event) {
        x.setOpacity(0.3);
    }

    public void bouttOut(MouseEvent event) {
        x.setOpacity(1);
    }

    public void bouttonExt(MouseEvent event) {
        Platform.exit();
    }
    public static ArrayList<Question> ques = DExam.getkhra();
    public static ArrayList<String> quesR = DExam.getkhraa();


    public void back(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("interProf.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }

    public void mod(MouseEvent mouseEvent) {
        try {
            q1.setText(ques.get(0).getEnonce());
            q2.setText(ques.get(1).getEnonce());
            q3.setText(ques.get(2).getEnonce());
            q4.setText(ques.get(3).getEnonce());
            q5.setText(ques.get(4).getEnonce());
            q6.setText(ques.get(5).getEnonce());

            ObservableList<String> ll = quesR.subList(0, 4).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));
            r1.setItems(ll);

            ObservableList<String> ll1 = quesR.subList(4, 8).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));;
            r2.setItems(ll1);
            ObservableList<String> ll2 = quesR.subList(8, 12).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));;
            r3.setItems(ll2);
            ObservableList<String> ll3 = quesR.subList(12, 16).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));;
            r4.setItems(ll3);
            ObservableList<String> ll4 = quesR.subList(16, 20).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));;
            r5.setItems( ll4);
            ObservableList<String> ll5 = quesR.subList(20, 24).stream().collect(Collector.of(
                    FXCollections::observableArrayList,
                    ObservableList::add,
                    (l1, l2) -> { l1.addAll(l2); return l1; }));;
            r6.setItems( ll5);
        }
        catch(NullPointerException n) {
            System.out.println("c pas ça bb");
        }

    }
    public int not=0;
    public void ok(MouseEvent mouseEvent) throws IOException {
        for (int i = 0; i < 6; i++) {
            if(ques.get(i).getEtat()==quesR.indexOf(r1.getValue())){
                not+=1;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Note");
            alert.setHeaderText(null);
            alert.setContentText("votre note est: "+not);
            alert.showAndWait();
        }
        File file = new File("Reponse.txt");
        if(file.createNewFile()){
            FileWriter fw=new FileWriter(file);
            for (int i = 0; i <6 ; i++) {
                fw.write(ques.get(i).getEnonce());
                fw.write(ques.get(i).getReponse().get(ques.get(i).getEtat()));
                fw.write("----");
            }
            fw.close();
        }
    }
}