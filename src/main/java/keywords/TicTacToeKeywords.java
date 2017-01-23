package keywords;

import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeModel model;
	
	public void startNewGame() {
		model = new TicTacToeModel();
	}
	
	public void markLocation(int row, int col) {
		model.setMark(row, col);
	}
	
	public String getMark(int row, int col) {
		return model.getMark(row, col).toString();
	}
    
	public String getWinner() {
		return model.getWinner();
	}
}
