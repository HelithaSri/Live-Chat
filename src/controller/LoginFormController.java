package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author Helitha Sri
 * @created 8/14/2022 - 10:36 AM
 * @project Live Chat
 */

public class LoginFormController {
    public JFXTextField txtLoginName;
    public AnchorPane logingPane;

    private double xOffset = 0;
    private double yOffset = 0;

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/UserForm.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT); //Use For Boarder TRANSPARENT
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset=event.getSceneX();
                yOffset=event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX()-xOffset);
                stage.setY(event.getScreenY()-yOffset);
            }
        });
        stage.setMinWidth(440);
        stage.setMinHeight(769);
        stage.setMaxWidth(440);
        stage.setMaxHeight(769);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        logingPane.getScene().getWindow().hide();
    }

    public void btnClose(ActionEvent actionEvent) {

    }

    public void btnMinimize(ActionEvent actionEvent) {

    }
}
