package edu.jsu.mcis;

import java.util.Scanner;

public class Main {



	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel();
		String winner = model.getWinner();
		boolean xTurn = true;
		while(winner == null) {
			model.printBoard();
			if(xTurn) {
				System.out.println("X's Turn");
			}
			else {
				System.out.println("O's Turn");
			}
			Scanner s = new Scanner(System.in);
			String location = s.nextLine();
			System.out.println("Enter the location in 'row col' format: ");
			int row = Character.getNumericValue(location.charAt(0));
			int col = Character.getNumericValue(location.charAt(2));
			model.setMark(row, col);
			model.getWinner();
			xTurn = !xTurn;
		}
		System.out.println("Game result: " + model.getWinner());
	}

}