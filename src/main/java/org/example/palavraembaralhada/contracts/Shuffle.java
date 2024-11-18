package org.example.palavraembaralhada.contracts;

import org.example.palavraembaralhada.enums.Level;

import java.util.Map;

public interface Shuffle {
    Map<String, String> shuffleWord(Level level);
}
