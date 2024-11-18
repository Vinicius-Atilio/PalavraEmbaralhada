package org.example.palavraembaralhada.usescase.factory;

import org.example.palavraembaralhada.usescase.generator.GameLevelWordGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleFactory {
    private GameLevelWordGenerator gameLevelWordGenerator;
    private final String[][] mappigns;

    public ShuffleFactory(GameLevelWordGenerator gameLevelWordGenerator) {
        this.gameLevelWordGenerator = gameLevelWordGenerator;
        this.mappigns = new String[][]{{"a", "4"}, {"e", "3"}, {"i", "1"}, {"o", "0"}, {"s", "5"}, {"t", "7"}};
    }

    public String createRandomShuffle(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        Random random = new Random();
        return switch (random.nextInt(3)) {
            case 0 -> this.getShuffled(word);
            case 1 -> this.getShuffledWithNumber(word);
            case 2 -> this.getShuffleMix(word);
            default -> word;
        };
    }

    private String getShuffled(String word) {
        if (word.isEmpty()) return null;
        String shuffledWord = getShuffledWord(word);
        return formatScrambledWord(shuffledWord);
    }

    private String getShuffledWithNumber(String word) {
        if (word.isEmpty()) return null;

        String shuffledWordWithNumbers = getStringWithNumbers(word);
        return formatScrambledWord(shuffledWordWithNumbers);
    }

    private String getShuffleMix(String word) {
        if (word.isEmpty()) return null;

        String shuffledWord = getShuffledWord(word);
        String shuffledWordMix = getStringWithNumbers(shuffledWord);
        return formatScrambledWord(shuffledWordMix);
    }

    private String getShuffledWord(String word) {
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);
        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }

        return shuffledString.toString();
    }

    private String getStringWithNumbers(String word) {
        for (String[] mapping : this.mappigns) {
            word = word.replaceAll(mapping[0], mapping[1]);
        }
        return word;
    }

    private static String formatScrambledWord(String word) {
        StringBuilder formattedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            formattedWord.append(" ").append(letter).append(" ");
        }
        return formattedWord.toString();
    }
}
