package org.comp301.ProfPractice.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        View view = new View();

        Scene scene = new Scene(view.render(), 500,500);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
