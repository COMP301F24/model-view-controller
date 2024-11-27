package org.comp301.tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import org.comp301.tictactoe.Controller.ControllerImpl;
import org.comp301.tictactoe.Model.Model;
import org.comp301.tictactoe.Model.ModelImpl;
import org.comp301.tictactoe.View.View;
import org.comp301.tictactoe.Controller.Controller;



public class App extends Application {


    @Override
    public void start(Stage stage){
        //model
        Model model = new ModelImpl();

        //controller
        Controller controller = new ControllerImpl(model);

        //View
        View view = new View(model, controller, stage);
        model.addObserver(view);


        Scene scene = new Scene(view.render());  //width and height
        scene.getStylesheets().add("style/tictactoe-style.css");
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
