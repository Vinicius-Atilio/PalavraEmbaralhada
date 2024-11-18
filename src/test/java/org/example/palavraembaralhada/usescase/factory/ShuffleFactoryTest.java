package org.example.palavraembaralhada.usescase.factory;

import org.example.palavraembaralhada.usescase.generator.GameLevelWordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class ShuffleFactoryTest {
	@Mock
	private GameLevelWordGenerator gameLevelWordGenerator;

	private ShuffleFactory shuffleFactory;

	@BeforeEach
	public void setup() {
		this.shuffleFactory = new ShuffleFactory(gameLevelWordGenerator);
	}

	@Test
	public void shouldCreateRandomShuffle() {
		String word = "fight";
		String randomShuffle = shuffleFactory.createRandomShuffle(word);
		assertNotNull(randomShuffle);
	}

	@Test
	public void shouldThrowExceptionWordIsNull() {
		assertThrows(IllegalArgumentException.class, () -> shuffleFactory.createRandomShuffle(null));
	}
}
