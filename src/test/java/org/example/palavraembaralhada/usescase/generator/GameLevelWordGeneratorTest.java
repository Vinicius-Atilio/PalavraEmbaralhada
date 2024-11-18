package org.example.palavraembaralhada.usescase.generator;


import org.example.palavraembaralhada.Entity.WordDataBase;
import org.example.palavraembaralhada.enums.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameLevelWordGeneratorTest {
	@Mock
	private WordDataBase wordDataBase;

	@InjectMocks
	private GameLevelWordGenerator gameLevelWordGenerator;

	@Test
	void shouldGeneratedWordWithLevelEasy() {
		when(this.wordDataBase.sortedWord())
				.thenReturn("boy");

		String generatedWord = gameLevelWordGenerator.generatedWord(Level.EASY);
		assertNotNull(generatedWord);
		assertTrue(generatedWord.length() <= 3);
	}

	@Test
	void shouldGeneratedWordWithLevelMedium() {
		when(this.wordDataBase.sortedWord())
				.thenReturn("fight");

		String generatedWord = gameLevelWordGenerator.generatedWord(Level.MEDIUM);
		assertNotNull(generatedWord);
		assertTrue(generatedWord.length() <= 5);
	}


	@Test
	void shouldGeneratedWordWithLevelHard() {
		when(this.wordDataBase.sortedWord())
				.thenReturn("combination");

		String generatedWord = gameLevelWordGenerator.generatedWord(Level.VERY_HARD);
		assertNotNull(generatedWord);
		assertTrue(generatedWord.length() > 7);
	}


	@Test
	void shouldThrowExceptionWhenWordIsNull() {
		doThrow(new IllegalArgumentException("Word list file not found: ")).when(this.wordDataBase).sortedWord();
		assertThrows(IllegalArgumentException.class, () -> this.gameLevelWordGenerator.generatedWord(Level.VERY_HARD));
	}

	@Test
	void shouldThrowExceptionWhenLevelIsNull() {
		assertThrows(IllegalArgumentException.class, () -> this.gameLevelWordGenerator.generatedWord(null));
	}
}
