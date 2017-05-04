package ticTacToe;

import java.util.*;

import javax.swing.JFrame;

import java.io.*;

public class TicTacToe {	
	// Fields
	private String[][] grid = new String[3][3];
	
	// Constructor
	public TicTacToe() {
		fillGrid(grid);
	}
	
	// Mutator Methods
	public void fillSpot(int row, int col, String player) {
		grid[row - 1][col - 1] = player;
	}
	public void fillGrid(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = " ";
			}
		}
	}
	public void turn(String s) {
		int row = 0;
		int col = 0;
		row = inputCatcher();
		col = inputCatcher();
		boolean valid = false;
		while (valid != true) {
			if (row > 3 || row < 1) {
				System.out.println("Please enter a valid row: ");
				row = inputCatcher();
			} else if (col > 3 || col < 1) {
				System.out.println("Please enter a valid column: ");
				col = inputCatcher();
			} else {
				valid = true;
			}
		}
		valid = false;
		boolean valid2 = false;
		while (valid2 != true) {
			if (isValid(row, col) == false) {
				System.out.println("Please enter a valid box: ");
				row = inputCatcher();
				col = inputCatcher();
				while (valid != true) {
					if (row > 3 || row < 1) {
						System.out.println("Please enter a valid row: ");
						row = inputCatcher();
					} else if (col > 3 || col < 1) {
						System.out.println("Please enter a valid column: ");
					col = inputCatcher();
					} else {
						valid = true;
					}
				}
			} else {
				valid2 = true;
			}
		}
		fillSpot(row, col, s);
	}
	
	// Accessor Methods
	public void printGrid() {
		int count = 1;
		System.out.println("  1 2 3");
		line();
		printRow(count);
		count++;
		line();
		printRow(count);
		count++;
		line();
		printRow(count);
		line();
	}
	public boolean isValid(int row, int col) {
		if (grid[row - 1][col - 1] != " ") {
			return false;
		}
		return true;
	}
	public boolean checkTie() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[row][col] == " ") {
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkWin() {
		for (int row = 0; row < 3; row++) {
			if (grid[row][0] != " ") {
				if (grid[row][0] == grid[row][1] && grid[row][0] == grid[row][2]) {
					return true;
				} else {
				}
			}
		}
		for (int col = 0; col < 3; col++) {
			if (grid[0][col] != " ") {
				if (grid[0][col] == grid[1][col] && grid[0][col] == grid[2][col]) {
					return true;
				} else {
				}
			}
		}
		if (grid[1][1] != " ") {
			if ((grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) || (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
				return true;
			}
		}
		return false;
	}
	
	// Helper Methods
	public void line() {
		System.out.println(" +-+-+-+");
	}
	public void printRow(int count) {
		int extra = 0;
		System.out.print(count + "|" + grid[count - 1][extra] + "|");
		extra++;
		System.out.print(grid[count - 1][extra] + "|");
		extra++;
		System.out.println(grid[count - 1][extra] + "|");
	}
	public int inputCatcher() {
		Scanner input = new Scanner(System.in);
		int num = 0;
		boolean tryTester = false;
		while (tryTester == false) {
			try {
				num = input.nextInt();
				tryTester = true;
			} catch (InputMismatchException e) {
				System.out.println("Please input a number.");
				tryTester = false;
				input.next();
			}
		}
		return num;
	}
}
