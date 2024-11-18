package org.example.palavraembaralhada.contracts;

import org.example.palavraembaralhada.enums.Level;

public interface Engine {
    void play(String input);
    void setupGame(Level level);
    boolean isGameOver();
    void timeToHunt();
    void timeToKill();
    void welcome();
    void nextRound();
    void playAgain();
    void hit();
    void winner();
    void loser();
}
