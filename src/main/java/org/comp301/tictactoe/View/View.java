package org.comp301.tictactoe.View;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.comp301.tictactoe.Controller.Controller;
import org.comp301.tictactoe.Model.Model;
import org.comp301.tictactoe.Model.Observer;

public class View implements FXComponent, Observer {
    private Model model;
    private Controller controller;
    private Stage stage;

    //private final Button[][] buttons;

    public View(Model model, Controller controller, Stage stage) {
        this.model = model;
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public Parent render() {
        VBox background = new VBox();

        Pane controlPanel = new HBox();
        background.getChildren().add(controlPanel);

        // Bonus container set to grow.
        Pane statusContainer = new HBox();
        HBox.setHgrow(statusContainer, Priority.ALWAYS);
        controlPanel.getChildren().add(statusContainer);


        Label status = new Label("Status:");
        statusContainer.getChildren().add(status);


        if (!model.isGameActive()) {
            if (model.hasWon()) {
                status.setText("Player " + model.getCurrentPlayer() + " wins!");
            } else {
                status.setText("It's a tie!");
            }
        }


        // The controlPanel has a reset button
        Button resetButton = new Button("Reset");
        resetButton.setOnAction((ActionEvent e) -> controller.handleReset());
        controlPanel.getChildren().add(resetButton);

        
        GridPane gameBoard = new GridPane();
        //9 buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                Button button = new Button(String.valueOf(model.getCell(i, j)));
                button.getStyleClass().add("tile");
                button.setOnAction(e -> controller.handleCellClick(row, col));//clicking any button is a play
                gameBoard.add(button, i, j);

                //Nice touch for disabling tiles that have already been clicked
                button.setDisable(model.getCell(i, j) != ' ' || !model.isGameActive());

            }
        }

        background.getChildren().add(gameBoard);
        return background;
    }

    @Override
    public void update() {
        this.stage.getScene().setRoot(render());
    }
}

