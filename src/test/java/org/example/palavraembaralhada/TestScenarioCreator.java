package org.example.palavraembaralhada;

import org.example.palavraembaralhada.Entity.builders.GameModeBuilder;
import org.example.palavraembaralhada.Entity.builders.RussianRouletteBuilder;
import org.example.palavraembaralhada.enums.Level;

public class TestScenarioCreator {

    public static GameModeBuilder aValidGameModeBuilder() {
        return new GameModeBuilder()
                .withGameOver(false)
                .withHit(false)
                .withPlayAgain(false)
                .withNextRound(false)
                .withAttempt(3)
                .withScore(20)
                .withLevel(Level.HARD)
                .withOriginalWord("commission")
                .withShuffleWord("n 0 1 5 5 1 m m 0 c")
                .withWinner(false)
                .withRussianRoulette(aValidRussianRouletteBuilder().build())
                .withRandomNumber(21);
    }

    public static RussianRouletteBuilder aValidRussianRouletteBuilder() {
        return new RussianRouletteBuilder()
                .withHunt(true)
                .withScoreOfDeath(21);
    }
}
