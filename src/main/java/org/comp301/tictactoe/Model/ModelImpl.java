package org.comp301.tictactoe.Model;

import java.util.ArrayList;
import java.util.List;


public class ModelImpl implements Model {
    private char[][] board;
    private char currentPlayer;  //X or O
    private boolean gameActive;
    private List<Observer> observers;

    public ModelImpl() {
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        this.currentPlayer = 'X';  //X is first player
        this.gameActive = true;
        this.observers = new ArrayList<>();
    }



    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isGameActive() {
        return gameActive;
    }


    public boolean hasWon() {
        // check each row; all elements are the same and not empty
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }

        // check each column; all elements are the same and not empty
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        // diagonally; top left to bottom right
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        // diagnoally; top-right to bottom-left
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

       //no winner
        return false;
    }

    public boolean isTie() {
        if (hasWon()) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // any empty cell means game is still ongoing
                }
            }
        }
        return true; // No empty cells, no winner, is a tie
    }



    public void makeMove(int row, int col) {
        if (gameActive && board[row][col] == ' ') {  //active game, empty cell
            board[row][col] = currentPlayer; //place Xs and Os
            if (hasWon()) {  //if there's winner, game is not active
                gameActive = false;
            }else if (isTie()) { //tie, game is not active
                gameActive = false;
            }
            else {  //else switch next player after a move is made
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
            notifyObservers();
        }
    }


    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = ' ';  //reset to all empty spaces again
            }
        }
        this.currentPlayer = 'X';  // X will be first player on reset
        this.gameActive = true;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}










