package org.comp301.tictactoe.Model;

public interface Observer {
        void update();  // when a model value is changed, the model calls update() on all active ModelObserver objects

}
