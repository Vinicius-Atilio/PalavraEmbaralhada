package org.example.palavraembaralhada.Entity;


import org.example.palavraembaralhada.enums.Level;
import org.junit.jupiter.api.Test;

import static org.example.palavraembaralhada.TestScenarioCreator.aValidGameModeBuilder;
import static org.example.palavraembaralhada.TestScenarioCreator.aValidRussianRouletteBuilder;
import static org.junit.jupiter.api.Assertions.*;

public class GameModeTest {

	@Test
	void shouldCreateGameMode() {
		var gameMode = aValidGameModeBuilder().build();
		assertFalse(gameMode.isGameOver());
		assertFalse(gameMode.isHit());
		assertFalse(gameMode.isPlayAgain());
		assertFalse(gameMode.isNextRound());
		assertEquals(3, gameMode.getAttempt());
		assertEquals(20, gameMode.getScore());
		assertEquals(Level.HARD, gameMode.getLevel());
		assertEquals("commission", gameMode.getOriginalWord());
		assertEquals("n 0 1 5 5 1 m m 0 c", gameMode.getShuffleWord());
		assertFalse(gameMode.isWinner());
		assertFalse(gameMode.isGameOver());
		assertTrue(gameMode.getRussianRoulette().isHunt());
		assertEquals(21, gameMode.getRussianRoulette().getScoreOfDeath());
	}


	@Test
	void shouldCreateGameModeEasy() {
		var gameMode = aValidGameModeBuilder().withScore(50).withLevel(Level.EASY).withOriginalWord("boy").build();
		gameMode.play("boy");
		assertTrue(gameMode.isHit());
		assertTrue(gameMode.isNextRound());
		assertFalse(gameMode.isPlayAgain());
		assertEquals(100, gameMode.getScore());
		assertTrue(gameMode.isWinner());
		assertTrue(gameMode.isGameOver());
	}


	@Test
	void shouldCreateGameModeVeryHard() {
		var gameMode = aValidGameModeBuilder()
				.withScore(45)
				.withLevel(Level.VERY_HARD)
				.withOriginalWord("respectfully")
				.withRussianRoulette(aValidRussianRouletteBuilder().withScoreOfDeath(50).build())
				.build();


		gameMode.play("respect");
		assertFalse(gameMode.isHit());
		assertFalse(gameMode.isNextRound());
		assertTrue(gameMode.isPlayAgain());
		assertTrue(gameMode.isTimeToKill());
		assertEquals(0, gameMode.getScore());
		assertFalse(gameMode.isWinner());
		assertTrue(gameMode.isGameOver());
	}
}
