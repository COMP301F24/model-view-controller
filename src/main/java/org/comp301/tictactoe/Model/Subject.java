package org.comp301.tictactoe.Model;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);

}
