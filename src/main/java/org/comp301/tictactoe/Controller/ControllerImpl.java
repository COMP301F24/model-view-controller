package org.comp301.tictactoe.Controller;

import org.comp301.tictactoe.Model.Model;

public class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl(Model model) {
        this.model = model;
    }

    public void handleCellClick(int row, int col) {
        model.makeMove(row, col);
    }

    public void handleReset() {
        model.resetBoard();
    }
}

