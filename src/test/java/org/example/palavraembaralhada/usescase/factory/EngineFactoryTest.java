package org.example.palavraembaralhada.usescase.factory;

import org.example.palavraembaralhada.contracts.Engine;
import org.example.palavraembaralhada.enums.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class EngineFactoryTest {

	private EngineFactory engineFactory;

	@BeforeEach
	public void setup() {
		this.engineFactory = new EngineFactory();
	}

	@Test
	public void shouldCreateEngine() {
		Engine gameEngine = engineFactory.createEngine(Level.HARD);
		assertNotNull(gameEngine);
	}
}
