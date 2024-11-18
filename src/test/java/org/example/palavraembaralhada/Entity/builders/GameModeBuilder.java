package org.example.palavraembaralhada.Entity.builders;

import org.example.palavraembaralhada.Entity.GameMode;
import org.example.palavraembaralhada.Entity.RussianRoulette;
import org.example.palavraembaralhada.enums.Level;

public class GameModeBuilder {
    private boolean gameOver;
    private boolean hit;
    private boolean playAgain;
    private boolean nextRound;
    private int attempt;
    private int score;
    private Level level;
    private String originalWord;
    private String shuffleWord;
    private boolean winner;
    private RussianRoulette russianRoulette;
    private int randomNumber;

    public static GameModeBuilder builder() {
        return new GameModeBuilder();
    }

    public GameMode build() {
        return new GameMode(gameOver, hit, playAgain, nextRound, attempt, score, level, originalWord, shuffleWord,
                winner, russianRoulette, randomNumber);
    }

    public GameModeBuilder withGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        return this;
    }

    public GameModeBuilder withHit(boolean hit) {
        this.hit = hit;
        return this;
    }

    public GameModeBuilder withPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
        return this;
    }

    public GameModeBuilder withNextRound(boolean nextRound) {
        this.nextRound = nextRound;
        return this;
    }

    public GameModeBuilder withAttempt(int attempt) {
        this.attempt = attempt;
        return this;
    }

    public GameModeBuilder withScore(int score) {
        this.score = score;
        return this;
    }

    public GameModeBuilder withLevel(Level level) {
        this.level = level;
        return this;
    }

    public GameModeBuilder withOriginalWord(String originalWord) {
        this.originalWord = originalWord;
        return this;
    }

    public GameModeBuilder withShuffleWord(String shuffleWord) {
        this.shuffleWord = shuffleWord;
        return this;
    }

    public GameModeBuilder withWinner(boolean winner) {
        this.winner = winner;
        return this;
    }

    public GameModeBuilder withRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
        return this;
    }

    public GameModeBuilder withRussianRoulette(RussianRoulette russianRoulette) {
        this.russianRoulette = russianRoulette;
        return this;
    }
}
