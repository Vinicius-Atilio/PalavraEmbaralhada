package org.example.palavraembaralhada.usescase.engine;

import org.example.palavraembaralhada.Entity.GameMode;
import org.example.palavraembaralhada.Entity.RussianRoulette;
import org.example.palavraembaralhada.contracts.Engine;
import org.example.palavraembaralhada.enums.Level;
import org.example.palavraembaralhada.usescase.shuffle.ShuffleGenerator;

import java.util.Map;

public class GameEngine implements Engine {
    private GameMode gameMode;
    private ShuffleGenerator shuffleGenerator;

    public GameEngine(GameMode gameMode, ShuffleGenerator shuffleGenerator) {
        this.gameMode = gameMode;
        this.shuffleGenerator = shuffleGenerator;
    }

    @Override
    public void play(String input) {
        this.gameMode.play(input);
    }

    @Override
    public void setupGame(Level level) {
        Map<String, String> result = shuffleGenerator.shuffleWord(level);
        switch (level) {
            case EASY, MEDIUM:
                this.gameMode = new GameMode(
                        5,
                        result.get("generatedWord"),
                        result.get("shuffledWord"),
                        level
                );
            case HARD, VERY_HARD:
                RussianRoulette roulette = new RussianRoulette(
                        0,
                        false
                );

                this.gameMode = new GameMode(
                        5,
                        result.get("generatedWord"),
                        result.get("shuffledWord"),
                        level,
                        roulette
                );
        }

    }

    @Override
    public boolean isGameOver() {
        if (this.gameMode == null)
            return false;

        return this.gameMode.isGameOver();
    }

    @Override
    public void timeToHunt() {
        if (this.gameMode.isTimeToHuntHard() || this.gameMode.isTimeToHuntVeryHard()) {
            System.out.println("🕒 Time is running out. Every moment brings death closer.");
            System.out.println("💣 Make your next move wisely... or it may be your last.");

            if (!gameMode.isTimeToKill()) {
                System.out.println("🌟 The adventure prevails! The path forward remains open.");
                System.out.println("Your adventure score stands stronger than the pull of death.");
            }
        }
    }

    @Override
    public void timeToKill() {
        if (gameMode.isTimeToKill()) {
            System.out.println("💀 The scales of fate tip towards the inevitable... it's time to kill.");
            System.out.println("⚔️ You feel the cold breath of death. No more adventuring, only survival matters now.");
            System.out.println("💀 GAME OVER 💀");
            System.out.println("The darkness has claimed you. your score " + gameMode.getScore() + " With a death score of " + gameMode.getRussianRoulette().getScoreOfDeath() + ", your journey ends in tragedy.");
            System.out.println("⚔️ The world fades to black, and the story of your quest ends here.");
            System.out.println("Your legacy is lost, buried in the sands of time... 🌑\n");
        }
    }

    @Override
    public void welcome() {
        System.out.println("⚔️ Welcome, brave soul! ⚔️");
        System.out.println();
        if (this.gameMode.isHighLevel()) {
            System.out.println("🩸 Beware, brave soul... this mode comes with a deadly twist.");
            System.out.println("🎲 The Russian Roulette mechanic is in play.");
            System.out.println("⚡ At any moment, your fate could be decided by a single spin of the chamber.");
            System.out.println("Luck and skill will both be needed to survive this brutal challenge.\n");
        }

        System.out.println();

        System.out.println("Your mission is simple: decipher the scrambled word.\n");
        shuffledInfo();
    }

    @Override
    public void nextRound() {
        if (gameMode.isNextRound()) {
            Map<String, String> result = shuffleGenerator.shuffleWord(this.gameMode.getLevel());

            this.gameMode.updateIfHit(result.get("generatedWord"), result.get("shuffledWord"));

            System.out.println("The winds of fate have shuffled the word to: ");
            System.out.println("🔮 " + gameMode.getShuffleWord() + " 🔮");
            System.out.println("You have " + gameMode.getAttempt() + " attempts to unlock its true form...\n");
            System.out.print("Your guess? ");
        }
    }

    @Override
    public void playAgain() {
        if (gameMode.isPlayAgain()) {
            System.out.println("❌ Alas, that is not the word. ");
        }

        if (gameMode.isPlayAgain() && gameMode.getAttempt() > 0) {
            System.out.println("The mystery persists... Try again! You have " + gameMode.getAttempt() + " more chances.\n");
            System.out.print("Your guess? ");
        }

        if (gameMode.isPlayAgain() && gameMode.getAttempt() == 0) {
            System.out.println("💀 The word remains a mystery, and your journey ends here.");
            System.out.println("The correct word was: '" + gameMode.getOriginalWord() + "'. Better luck next time, traveler...\n");
        }
    }

    @Override
    public void hit() {
        if (gameMode.isHit() && !gameMode.isTimeToKill()) {
            System.out.println("\n✨ Well done, adventurer! ✨");
            System.out.println("📜 Current Adventure Score: " + gameMode.getScore());
            System.out.println("You have unlocked the word: '" + gameMode.getOriginalWord() + "'!");
            System.out.println("Your wisdom shines through the darkness. 🏆\n");
        }
    }

    @Override
    public void winner() {
        if (gameMode.isWinner()) {
            System.out.println("🌟✨ Congratulations, adventurer! ✨🌟");
            System.out.println("You have reached the fabled 100 adventure points, marking your victory.");
            System.out.println("🏆 With " + gameMode.getScore() + " points, your name will echo in legends, written in the stars!");
            System.out.println("You’ve overcome every challenge, and your journey will be remembered for ages. 🌍\n");
            System.out.println("🎉 VICTORY IS YOURS! 🎉\n");
        }
    }

    @Override
    public void loser() {
        if (gameMode.isGameOver() && gameMode.getAttempt() == 0 && !gameMode.isTimeToKill()) {
            System.out.println("💣 You have run out of attempts... with score " + gameMode.getScore());
            System.out.println("The adventure has slipped through your fingers.");
            System.out.println("⚔️ Despite your best efforts, fate had other plans.");
            System.out.println("With no more chances left, the game is over. 🕯️");
            System.out.println("Your adventure ends, unfulfilled... but the echoes of your journey may linger...\n");
        }
    }

    private void shuffledInfo() {
        System.out.println("The winds of fate have shuffled the word to: ");
        System.out.println("🔮 " + gameMode.getShuffleWord() + " 🔮");
        System.out.println("You have " + gameMode.getAttempt() + " attempts to unlock its true form...\n");
        System.out.print("Your guess? ");
    }
}
