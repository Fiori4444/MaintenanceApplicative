
package trivia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
	@Test
	@Disabled
	public void caracterizationTest() {
		// runs 10.000 "random" games to see the output of old and new code mathces
		for (int seed = 1; seed < 10_000; seed++) {
			testSeed(seed, false);
		}
	}

	@Test
	@Disabled("enable back and set a particular seed to see the output")
	public void oneSeed() {
		testSeed(1, true);
	}

	private void testSeed(int seed, boolean printExpected) {
		String expectedOutput = extractOutput(new Random(seed), new GameOld());
		if (printExpected) {
			System.out.println(expectedOutput);
		}
		String actualOutput = extractOutput(new Random(seed), new Game());
		assertEquals(expectedOutput, actualOutput);
	}

	private String extractOutput(Random rand, IGame aGame) {
		PrintStream old = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (PrintStream inmemory = new PrintStream(baos)) {
			// WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
			System.setOut(inmemory);

			aGame.addPlayer("Chet");
			aGame.addPlayer("Pat");
			aGame.addPlayer("Sue");

			boolean notAWinner = false;
			do {
				aGame.roll(rand.nextInt(5) + 1);

				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.handleWrongAnswer();
				} else {
					notAWinner = aGame.handleCorrectAnswer();
				}

			} while (notAWinner);
		} finally {
			System.setOut(old);
		}

		return new String(baos.toByteArray());
	}

	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	void testAddPlayer() {
		assertTrue(game.addPlayer("Alice"));
		assertEquals(1, game.howManyPlayers());

		assertTrue(game.addPlayer("Bob"));
		assertEquals(2, game.howManyPlayers());
	}

	@Test
	void testIsPlayable() {
		assertFalse(game.isPlayable());
		game.addPlayer("Alice");
		assertFalse(game.isPlayable());
		game.addPlayer("Bob");
		assertTrue(game.isPlayable());
	}

	@Test
	void testRollWithoutPenaltyBox() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");

		game.roll(4);
		assertEquals(5, game.getPlayers().get(0).getPlayerPosition());
	}

	@Test
	void testRollWithPenaltyBox() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");
		game.getPlayers().get(0).setInPenaltyBox(true);

		game.roll(3);
		assertTrue(game.getIsGettingOutOfPenaltyBox());

		game.roll(2);
		assertFalse(game.getIsGettingOutOfPenaltyBox());
	}


	@Test
	void testHandleCorrectAnswer() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");

		assertTrue(game.handleCorrectAnswer());
		assertEquals(1, game.getPlayers().get(0).getScore());
	}

	@Test
	void testHandleCorrectAnswerInPenaltyBox() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");
		game.getPlayers().get(0).setInPenaltyBox(true);
		game.setIsGettingOutOfPenaltyBox(false);

		assertTrue(game.handleCorrectAnswer());
		assertEquals(0, game.getPlayers().get(0).getScore());
	}

	@Test
	void testHandleCorrectAnswerWinning() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");
		game.getPlayers().get(0).setScore(5);

		assertFalse(game.handleCorrectAnswer());
	}

	@Test
	void testHandleWrongAnswer() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");

		assertTrue(game.handleWrongAnswer());
		assertTrue(game.getPlayers().get(0).getInPenaltyBox());
	}

	@Test
	void testHandleLastPlayerTurn() {
		game.addPlayer("Alice");
		game.addPlayer("Bob");

		game.setCurrentPlayer(2);
		game.handleLastPLayerTurn();
		assertEquals(0, game.getCurrentPlayer());
	}
}
