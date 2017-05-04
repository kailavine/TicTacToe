package ticTacToe;

import javax.swing.*;

public class TicTacToeRunner {
	
	public static void main(String[] args) {		
		TicTacToe grid = new TicTacToe();
		String p1 = "x";
		String p2 = "o";
		System.out.println("Player 1 is 'x'.");
		System.out.println("Player 2 is 'o'.");
		System.out.println();
		System.out.println("Place your mark in any square going \"row\" \"column\".");
		System.out.println("For instance, type in \"1\" & \"2\" and your mark is placed like this:");
		grid.fillSpot(1, 2, "x");
		grid.printGrid();
		grid.fillSpot(1, 2, " ");
		System.out.println();
		System.out.println("Remember, once you put down a row or column, it's permanent! (Unless it's not valid!)");
		System.out.println("Start!");
		boolean win = false;
		boolean tie = false;
		int turn = 1;
		grid.printGrid();
		System.out.println();
		while (win == false && tie == false) {
			if (turn == 1) {
				System.out.println("Player 1's Turn");
				grid.turn(p1);
				turn = 2;
			} else if (turn == 2) {
				System.out.println("Player 2's Turn");
				grid.turn(p2);
				turn = 1;
			} else {
			}
			grid.printGrid();
			System.out.println();
			win = grid.checkWin();
			if (win == true) {
				if (turn == 2) {
					System.out.println("Player 1 wins!");
				} else {
					System.out.println("Player 2 wins!");
				}
			}
			tie = grid.checkTie();
			if (tie == true && win == false) {
				System.out.println("Tie!");
			}
		}
		
	}
}
