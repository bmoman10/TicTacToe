package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToeGame extends JPanel implements ActionListener {
	
	private TicTacToeModel model;
	private JFrame frame = new JFrame("Tic Tac Toe");
	private JButton[][] buttons = new JButton[3][3];
	private JLabel messageLabel;
	
	public TicTacToeGame() {
		super();
		model = new TicTacToeModel();
		messageLabel = new JLabel("X Turn");
		frame.setSize(350, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(event.getSource() == buttons[i][j]) {
					model.setMark(i, j);
					buttons[i][j].setText(model.getMark(i, j).toString());
					buttons[i][j].setEnabled(false);
					if(model.getWinner() == "X") {
						messageLabel.setText("X Wins!");
						new Thread(new Runnable() {
							public void run() {
								JOptionPane.showMessageDialog(null, "The winner is " + model.getWinner(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
							}
						}).start();
						
					}
					else if(model.getWinner() == "O") {
						messageLabel.setText("O Wins!");
						new Thread(new Runnable() {
							public void run() {
								JOptionPane.showMessageDialog(null, "The winner is " + model.getWinner(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
							}
						}).start();
					}
					else if(model.getWinner() == "TIE") {
						messageLabel.setText("Tie Game");
						new Thread(new Runnable() {
							public void run() {
								JOptionPane.showMessageDialog(null, "The winner is " + model.getWinner(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
							}
						}).start();
					}
					else {
						if(messageLabel.getText() == "X Turn") {
							messageLabel.setText("O Turn");
						}
						else {
							messageLabel.setText("X Turn");
						}
					}
				}
			}
		}
	}
	
	private void initialize() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel messagePanel = new JPanel(new BorderLayout());
		JPanel game = new JPanel(new GridLayout(3,3));
		
		frame.add(mainPanel);
		game.setPreferredSize(new Dimension(300, 300));
		messagePanel.setPreferredSize(new Dimension(300, 50));
		
		mainPanel.add(messagePanel, BorderLayout.NORTH);
		mainPanel.add(game, BorderLayout.SOUTH);
		messagePanel.add(messageLabel);
		
		
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();             
				buttons[i][j].setText("");
				buttons[i][j].setVisible(true);
				buttons[i][j].setName("Location" + i + j);				
				buttons[i][j].addActionListener(this);
				game.add(buttons[i][j]);        
			}
		}
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.initialize();
	}
}