package org.example.palavraembaralhada.Entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WordDataBaseTest {
	private WordDataBase wordDataBase;

	@BeforeEach
	void setUp() {
		this.wordDataBase = new WordDataBase();
	}

	@Test
	void shouldSortRandomWord() {
		var word = this.wordDataBase.sortedWord();
		assertNotNull(word);
	}
}
