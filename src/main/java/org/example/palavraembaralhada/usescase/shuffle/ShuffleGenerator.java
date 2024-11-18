package org.example.palavraembaralhada.usescase.shuffle;

import org.example.palavraembaralhada.contracts.Shuffle;
import org.example.palavraembaralhada.enums.Level;
import org.example.palavraembaralhada.usescase.factory.ShuffleFactory;
import org.example.palavraembaralhada.usescase.generator.GameLevelWordGenerator;

import java.util.HashMap;
import java.util.Map;

public class ShuffleGenerator implements Shuffle {
    private final GameLevelWordGenerator generator;
    private final ShuffleFactory shuffleFactory;
    private final  Map<String, String> result;

    public ShuffleGenerator(GameLevelWordGenerator generator, ShuffleFactory shuffleFactory) {
        this.generator = generator;
        this.shuffleFactory = shuffleFactory;
        this.result = new HashMap<>();
    }

    @Override
    public Map<String, String> shuffleWord(Level level) {
        if (level == null)
            throw new IllegalArgumentException("Level cannot be null");

        String generatedWord = this.generator.generatedWord(level);
        String shuffledWord = this.shuffleFactory.createRandomShuffle(generatedWord);
        this.result.put("generatedWord", generatedWord);
        this.result.put("shuffledWord", shuffledWord);
        return result;
    }
}
