import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

/**
 * @author Helitha Sri
 * @created 8/14/2022 - 11:54 AM
 * @project Live Chat
 */

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
//        primaryStage.initStyle(StageStyle.TRANSPARENT); //Use For Boarder TRANSPARENT
        primaryStage.setMinWidth(458);
        primaryStage.setMinHeight(769);
        primaryStage.setMaxWidth(458);
        primaryStage.setMaxHeight(769);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
