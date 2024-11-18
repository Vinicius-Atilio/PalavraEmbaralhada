package org.example.palavraembaralhada.usescase.shuffle;


import org.example.palavraembaralhada.enums.Level;
import org.example.palavraembaralhada.usescase.factory.ShuffleFactory;
import org.example.palavraembaralhada.usescase.generator.GameLevelWordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShuffleGeneratorTest {
	@Mock
	private GameLevelWordGenerator generator;
	@Mock
	private ShuffleFactory shuffleFactory;

	private ShuffleGenerator shuffleGenerator;

	@BeforeEach
	void setUp() {
		shuffleGenerator = new ShuffleGenerator(generator, shuffleFactory);
	}

	@Test
	public void shouldShuffleWord() {
		// TODO: initialize args
		// TODO: assert scenario
		when(this.generator.generatedWord(Level.VERY_HARD))
				.thenReturn("combination");

		when(this.shuffleFactory.createRandomShuffle("combination"))
				.thenReturn("n 0 1 t 4 n 1 b m 0 c");

		Map<String,String> shuffleWord = shuffleGenerator.shuffleWord(Level.VERY_HARD);


		assertNotNull(shuffleWord.get("generatedWord"));
		assertNotNull(shuffleWord.get("shuffledWord"));
		assertTrue(shuffleWord.get("generatedWord").length() > 7);
		assertTrue(shuffleWord.get("shuffledWord").length() > 7);
	}

	@Test
	void shouldThrowExceptionWhenLevelIsNull() {
		lenient().doThrow(new IllegalArgumentException("Level cannot be null")).when(this.generator).generatedWord(null);
		assertThrows(IllegalArgumentException.class, () -> this.shuffleGenerator.shuffleWord(null));
	}
}
