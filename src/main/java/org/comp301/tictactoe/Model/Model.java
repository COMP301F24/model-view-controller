package org.comp301.tictactoe.Model;

public interface Model extends Subject {
    char getCurrentPlayer();
    char getCell(int row, int col);
    boolean isGameActive();
    boolean hasWon();
    boolean isTie();
    void makeMove(int row, int col);
    void resetBoard();
}
