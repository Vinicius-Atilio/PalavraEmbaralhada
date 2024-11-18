package org.example.palavraembaralhada.usescase.generator;

import org.example.palavraembaralhada.Entity.WordDataBase;
import org.example.palavraembaralhada.enums.Level;

public class GameLevelWordGenerator {
    private WordDataBase wordDataBase;

    public GameLevelWordGenerator(WordDataBase wordDataBase) {
        this.wordDataBase = wordDataBase;
    }

    public String generatedWord(Level level) {
        if (level == null)
            throw new IllegalArgumentException("Level cannot be null");

        String word = this.wordDataBase.sortedWord();
        while (lvl(word, level)) {
            word = wordDataBase.sortedWord();
        }

        return word;
    }

    private static boolean lvl(String word, Level level) {
        if (word == null)
            throw new IllegalArgumentException("Word cannot be null");

        if (level == Level.EASY || level == Level.MEDIUM) {
            return word.length() > wordByLevel(level);
        }

        return word.length() < wordByLevel(level);
    }

    private static int wordByLevel(Level level) {
        return switch (level) {
            case Level.EASY -> 3;
            case Level.MEDIUM -> 5;
            case Level.HARD -> 6;
            case Level.VERY_HARD -> 7;
        };
    }
}
