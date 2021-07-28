package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InterP {
    @FXML
    public BorderPane bp;
    public AnchorPane ap;
    public Label x;

    public void Pclick(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }
    public void Clicky(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("Profil.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }

    public void ClickExam(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("Exam.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }

    //load page
    /*public void loadPage(String p) throws IOException {
        Parent root=null;
        root=FXMLLoader.load(getClass().getResource(p+".fxml"));
        bp.setCenter(root);
    }

    public void Bprofil(MouseEvent mouseEvent) throws IOException {
        loadPage("Profil");
    }*/

    public void Bdepo(MouseEvent mouseEvent) {
    }
    public void interNot(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("InterNote.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }

    public void Bnot(MouseEvent mouseEvent) {
    }
    public void bouttIn(MouseEvent event){
        x.setOpacity(0.3);
    }
    public void bouttOut(MouseEvent event){
        x.setOpacity(1);
    }
    public void bouttonExt(MouseEvent event){
        Platform.exit();
    }

    public void modif(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("ModifRes.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }
}
