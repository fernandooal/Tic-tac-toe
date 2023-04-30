package projetoPessoal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	
	static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard);
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Jogador 1, escolha uma posição (1-9):");
			int pos1 = scan.nextInt();
			while(player1Positions.contains(pos1) || player2Positions.contains(pos1)) {
				System.out.println("Posição ocupada! Escolha outra casa: ");
				pos1 = scan.nextInt();
			}
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			
			placePiece(gameBoard, pos1, "player1");
	
			printGameBoard(gameBoard);
			String result = checkWinner();
			System.out.println(result);
			
			if(result.length() > 0) {
				break;
			}
			
			System.out.println("Jogador 2, escolha uma posição (1-9):");
			int pos2 = scan.nextInt();
			while(player1Positions.contains(pos2) || player2Positions.contains(pos2)) {
				System.out.println("Posição ocupada! Escolha outra casa: ");
				pos2 = scan.nextInt();
			}
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			
			
			placePiece(gameBoard, pos2, "player2");
			
			printGameBoard(gameBoard);
			
			String result2 = checkWinner();
			System.out.println(result2);
			
			if(result2.length() > 0) {
				break;
			}
			
			}
		}

		
	
	
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player1")) {
			symbol = 'X';
			player1Positions.add(pos);
		} else if(user.equals("player2")) {
			symbol = 'O';
			player2Positions.add(pos);
		}
		
		switch(pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6); 
		List botRow = Arrays.asList(7, 8, 9); 
		List leftCol = Arrays.asList(1, 4, 7); 
		List midCol = Arrays.asList(2, 5, 8); 
		List rightCol = Arrays.asList(3, 6, 9); 
		List cross1 = Arrays.asList(1, 5, 9); 
		List cross2 = Arrays.asList(3, 5, 7); 
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(player1Positions.containsAll(l)) {
				return "Parabéns jogador 1, você ganhou!";
			} else if(player2Positions.containsAll(l)) {
				return "Parabéns jogador 2, você ganhou!";
			} else if(player1Positions.size() + player2Positions.size() == 9){
				return "Empate!";
			}
		}
		
		return "";
	}
	
}

	


