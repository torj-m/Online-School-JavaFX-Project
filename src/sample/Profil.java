package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Profil {
    public TextField np,dn,tel,em,mp;


    Connection com = DB.connect();
    PreparedStatement st;



    double xOffset, yOffset;
    public Label x,msg;

    public void sauve(MouseEvent mouseEvent) {
        {
            try {
                st = com.prepareStatement("update etudiant  set name=? , datenaiss=?, tel=?,pass=? where mail= ? ");

                st.setString (1,np.getText());

                st.setString(2,dn.getText() );
                st.setString(3,tel.getText() );
                st.setString(4,mp.getText() );
                st.setString(5,em.getText() );



                //st.executeQuery();
                st.executeQuery();
                msg.setVisible(true);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void init(MouseEvent contextMenuEvent) {
        np.setText("");
        dn.setText("");
        tel.setText("");
        em.setText("");
        mp.setText("");
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
    public void back(MouseEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("interP.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) event.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }
}