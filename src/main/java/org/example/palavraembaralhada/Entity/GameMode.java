package org.example.palavraembaralhada.Entity;

import org.example.palavraembaralhada.enums.Level;

public class GameMode {
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

    public GameMode() {
    }

    public GameMode(int attempt, String generatedWord, String shuffledWord, Level level) {
        this.gameOver = false;
        this.hit = false;
        this.playAgain = false;
        this.score = 0;
        this.attempt = attempt;
        this.originalWord = generatedWord;
        this.shuffleWord = shuffledWord;
        this.level = level;
    }


    public GameMode(int attempt, String generatedWord, String shuffledWord, Level level, RussianRoulette russianRoulette) {
        this.gameOver = false;
        this.hit = false;
        this.playAgain = false;
        this.score = 0;
        this.attempt = attempt;
        this.originalWord = generatedWord;
        this.shuffleWord = shuffledWord;
        this.level = level;
        this.russianRoulette = russianRoulette;
    }

    public GameMode(boolean gameOver, boolean hit, boolean playAgain, boolean nextRound, int attempt, int score,
                    Level level, String originalWord, String shuffleWord, boolean winner, RussianRoulette russianRoulette, int randomNumber) {
        this.gameOver = gameOver;
        this.hit = hit;
        this.playAgain = playAgain;
        this.nextRound = nextRound;
        this.attempt = attempt;
        this.score = score;
        this.level = level;
        this.originalWord = originalWord;
        this.shuffleWord = shuffleWord;
        this.winner = winner;
        this.russianRoulette = russianRoulette;
        this.randomNumber = randomNumber;
    }

    public Level getLevel() {
        return level;
    }

    public void play(String input) {
        if (input == null || attempt == 0)
            return;

        switch (level) {
           case EASY -> this.easyMode(input);
           case MEDIUM -> this.mediumMode(input);
           case HARD -> this.hardMode(input);
           case VERY_HARD -> this.veryHardMode(input);
        }
    }


    private void easyMode(String input) {
        if (input.equals(this.originalWord)) {
            this.score += 50;
            makeHit();
        } else {
            playAgain();
        }

        verifyIfGameEnd();
    }


    private void mediumMode(String input) {
        if (input.equals(this.originalWord)) {
            this.score += 30;
            makeHit();
        } else {
            playAgain();
        }

        verifyIfGameEnd();
    }

    private void hardMode(String input) {
        if (input.equals(this.originalWord)) {
            this.score += 25;
            makeHit();
        } else {
            playAgain();
        }

        verifyIfGameEnd();
    }

    private void veryHardMode(String input) {
        if (input.equals(this.originalWord)) {
            this.score += 20;
            makeHit();
        } else {
            playAgain();
        }

        verifyIfGameEnd();
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getShuffleWord() {
        return shuffleWord;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isNextRound() {
        return nextRound;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public int getScore() {
        return score;
    }

    public RussianRoulette getRussianRoulette() {
        return russianRoulette;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getAttempt() {
        return attempt;
    }

    private void playAgain() {
        this.playAgain = true;
        this.hit = false;
        this.attempt--;
    }

    private void makeHit() {
        this.hit = true;
        this.nextRound = true;
        this.playAgain = false;
    }

    private void verifyIfGameEnd() {
        if (this.russianRoulette != null && this.russianRoulette.isHunt()) {
            this.startHunt();
        }

        if (this.score >= 100) {
            this.winner = true;
            this.gameOver = true;
        }

        if (this.attempt == 0) {
            this.gameOver = true;
        }

        if (isTimeToHuntHard() || isTimeToHuntVeryHard() ) {
            if (russianRoulette != null) {
                this.russianRoulette.setHunt(true);
            }
        }
    }

    private void startHunt() {
        if (!isHighLevel())
            return;

        this.randomNumber = 0;
        this.randomNumber = (int)(Math.random() * 101);
        if (this.randomNumber > this.score) {
            if (this.level == Level.VERY_HARD) {
                this.score -= 5;
                russianRoulette.setScoreOfDeath(5);
            } else {
                this.score -= 3;
                russianRoulette.setScoreOfDeath(3);
            }
        }

        if (isTimeToKill()) {
            this.score = 0;
            this.gameOver = true;
        }
    }

    public boolean isTimeToHuntHard() {
        return this.level == Level.HARD && this.score >= 30;
    }

    public boolean isTimeToHuntVeryHard() {
        return this.level == Level.VERY_HARD && this.score >= 25;
    }

    public boolean isTimeToKill() {
        return russianRoulette != null && russianRoulette.isHunt() && russianRoulette.getScoreOfDeath() >= this.score;
    }

    public boolean isHighLevel() {
        return this.level == Level.HARD || this.level == Level.VERY_HARD;
    }

    public void updateIfHit(String generatedWord, String shuffledWord) {
        this.hit = false;
        this.nextRound = false;
        this.playAgain = false;
        this.originalWord = generatedWord;
        this.shuffleWord = shuffledWord;
    }
}
