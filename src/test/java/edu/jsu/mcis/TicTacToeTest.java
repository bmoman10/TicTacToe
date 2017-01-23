package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToeModel model = new TicTacToeModel();
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				TicTacToeModel.Mark m = model.getMark(row, col);
				assertEquals(TicTacToeModel.Mark.EMPTY, m);
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 2);
		TicTacToeModel.Mark m = model.getMark(0, 2);
		assertEquals(TicTacToeModel.Mark.X, m);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		model.setMark(2, 0);
		TicTacToeModel.Mark m = model.getMark(2, 0);
		assertEquals(TicTacToeModel.Mark.O, m);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		TicTacToeModel.Mark mOne = model.getMark(0, 0);
		model.setMark(0, 0);
		TicTacToeModel.Mark mTwo = model.getMark(0, 0);
		assertEquals(mOne, mTwo);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		String winner = model.getWinner();
		assertEquals(null, winner);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		model.setMark(1, 0);
		model.setMark(0, 1);
		model.setMark(1, 1);
		model.setMark(0, 2);
		String winner = model.getWinner();
		assertEquals("X", winner);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		model.setMark(1, 1);
		model.setMark(0, 2);
		model.setMark(0, 1);
		model.setMark(2, 1);
		model.setMark(2, 0);
		model.setMark(1, 0);
		model.setMark(2, 2);
		model.setMark(1, 2);
		String winner = model.getWinner();
		assertEquals("TIE", winner);
	}

	@Test
	public void testGameIsWonByODiagonally() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0, 0);
		model.setMark(2, 0);
		model.setMark(2, 2);
		model.setMark(1, 1);
		model.setMark(1, 2);
		model.setMark(0, 2);
		String winner = model.getWinner();
		assertEquals("O", winner);
	}
}
