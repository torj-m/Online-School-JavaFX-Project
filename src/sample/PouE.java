package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PouE {

    public Label labE;
    public Label labP;
    public ImageView imp;
    public ImageView ime;
    public Label x;

    double xOffset,yOffset;
    public void mouseIn1(MouseEvent event){
        KeyValue k = new KeyValue(labP.opacityProperty(),1, Interpolator.EASE_IN);
        KeyValue ki = new KeyValue(imp.opacityProperty(),0.3, Interpolator.EASE_IN);
        KeyFrame kk = new KeyFrame(Duration.seconds(0.5),k,ki);
        Timeline t =new Timeline();
        t.getKeyFrames().add(kk);
        t.play();
    }
    public void mouseOut1(MouseEvent event){
        KeyValue k = new KeyValue(labP.opacityProperty(),0, Interpolator.EASE_IN);
        KeyValue ki = new KeyValue(imp.opacityProperty(),1, Interpolator.EASE_IN);
        KeyFrame kk = new KeyFrame(Duration.seconds(0.5),k,ki);
        Timeline t =new Timeline();
        t.getKeyFrames().add(kk);
        t.play();
    }
    public void mouseIn2(MouseEvent event){
        KeyValue k = new KeyValue(labE.opacityProperty(),1, Interpolator.EASE_IN);
        KeyValue ki = new KeyValue(ime.opacityProperty(),0.3, Interpolator.EASE_IN);
        KeyFrame kk = new KeyFrame(Duration.seconds(0.5),k,ki);
        Timeline t =new Timeline();
        t.getKeyFrames().add(kk);
        t.play();
    }
    public void mouseOut2(MouseEvent event){
        KeyValue k = new KeyValue(labE.opacityProperty(),0, Interpolator.EASE_IN);
        KeyValue ki = new KeyValue(ime.opacityProperty(),1, Interpolator.EASE_IN);
        KeyFrame kk = new KeyFrame(Duration.seconds(0.5),k,ki);
        Timeline t =new Timeline();
        t.getKeyFrames().add(kk);
        t.play();
    }
    public void Pclick(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene Slogin=new Scene(login,500,500);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();

        //DragAndDrop
        login.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }

        });
        login.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                log.setX(event.getScreenX()-xOffset);
                log.setY(event.getScreenY()-yOffset);
            }

        });
    }

    //ExitButtonEffect
    public void bouttIn(MouseEvent event){
        x.setOpacity(0.3);
    }
    public void bouttOut(MouseEvent event){
        x.setOpacity(1);
    }
    public void bouttonExt(MouseEvent event){
        Platform.exit();
    }
}
