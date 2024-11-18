package org.example.palavraembaralhada.usescase.factory;

import org.example.palavraembaralhada.Entity.GameMode;
import org.example.palavraembaralhada.Entity.WordDataBase;
import org.example.palavraembaralhada.contracts.Engine;
import org.example.palavraembaralhada.enums.Level;
import org.example.palavraembaralhada.usescase.engine.GameEngine;
import org.example.palavraembaralhada.usescase.generator.GameLevelWordGenerator;
import org.example.palavraembaralhada.usescase.shuffle.ShuffleGenerator;

public class EngineFactory {
    public Engine createEngine(Level level) {
        WordDataBase wordDataBase = new WordDataBase();
        GameLevelWordGenerator generator = new GameLevelWordGenerator(wordDataBase);

        ShuffleFactory shuffleFactory = new ShuffleFactory(generator);
        ShuffleGenerator shuffleGenerator = new ShuffleGenerator(generator, shuffleFactory);

        GameMode gameMode = new GameMode();
        GameEngine gameEngine = new GameEngine(gameMode, shuffleGenerator);
        gameEngine.setupGame(level);
        return gameEngine;
    }
}
