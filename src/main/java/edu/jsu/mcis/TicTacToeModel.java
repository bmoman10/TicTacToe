package edu.jsu.mcis;

public class TicTacToeModel {

	public enum Mark { EMPTY, X, O };
	private Mark[][] board;
	private boolean xTurn;
	public String winner;
	
	public TicTacToeModel() {
		board = new Mark[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = Mark.EMPTY;
			}
		}
		xTurn = true;
		winner = null;
	}
	
	public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
               System.out.print(board[i][j] + " | ");
            }
			System.out.println();
			System.out.println("-------------");
        }
    }
	
	public Mark getMark(int row, int col) {
		return board[row][col];
	}	

	public void setMark(int row, int col) {
		Mark m = (xTurn)? Mark.X : Mark.O;
		if(board[row][col] == Mark.EMPTY) {
			board[row][col] = m;
			xTurn = !xTurn;
		}
	}
	
	public String getWinner() {
		checkGameOver();
		if(boardIsFull() && this.winner == null) {
			this.winner = "TIE";
		}
		return this.winner;
	}
	
	public boolean boardIsFull() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(getMark(i, j) == Mark.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void checkGameOver() {
		for(int i=0; i<3; i++) {
			boolean h = getMark(i, 0) == getMark(i, 1) && getMark(i, 1) == getMark(i, 2);
			boolean v = getMark(0, i) == getMark(1, i) && getMark(1, i) == getMark(2, i);
			if(h && getMark(i, 0) != Mark.EMPTY) {
				this.winner = getMark(i, 0).toString();
			}
			else if(v && getMark(0, i) != Mark.EMPTY) {
				this.winner = getMark(0, i).toString();
			}
		}
		
		if(this.winner == null) {
			if(getMark(0, 0) == getMark(1, 1) && getMark(1, 1) == getMark(2, 2) && getMark(0, 0) != Mark.EMPTY) {
				this.winner = getMark(0, 0).toString();
			}
			else if(getMark(2, 0) == getMark(1, 1) && getMark(1, 1) == getMark(0, 2) && getMark(2, 0) != Mark.EMPTY) {
				this.winner = getMark(2, 0).toString();
			}
		}
	}
	
}
