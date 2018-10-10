import javax.print.DocFlavor;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Board
{
	final String playerAI = "O";
	final String playerHuman = "X";
	//List<Integer> scores = new ArrayList<>();
	Cell[] cells;


	Board()
	{
		this.cells = new Cell[9];
		for (int i = 0; i < cells.length; i++)
		{
			cells[i] = new Cell(String.valueOf(i + 1), true);
		}
	}


	//copy constructor
	public Board(Board board)
	{
		this.cells = new Cell[9];
		for (int i = 0; i < this.cells.length; i++)
		{
			this.cells[i] = new Cell(String.valueOf(board.cells[i].numberOnBoard),board.cells[i].spaceIsEmpty);
		}
	}

	// place an X or an O where the current player selected
	void move(int userInput, String currentPlayer, Cell[] board)
	{
			board[userInput - 1].numberOnBoard = currentPlayer;
			board[userInput - 1].spaceIsEmpty = false;

	}

	ArrayList<Cell> numberOfAvailableCells(Cell[] board)
	{
		ArrayList<Cell> emptyCells = new ArrayList<>();

		for (Cell cell : board)
		{
			if (cell.spaceIsEmpty)
			{
				emptyCells.add(cell);
			}
		}
		return emptyCells;
	}

	//set all the cells to blank
	void setupBoard(Cell[] board)
	{
		board[0].numberOnBoard = "O";
		board[0].spaceIsEmpty = false;
		board[1].numberOnBoard = "X";
		board[1].spaceIsEmpty = false;
		board[2].numberOnBoard = "3";
		board[3].numberOnBoard = "4";
		board[4].numberOnBoard = "5";
		board[5].numberOnBoard = "X";
		board[5].spaceIsEmpty = false;
		board[6].numberOnBoard = "O";
		board[6].spaceIsEmpty = false;
		board[7].numberOnBoard = "O";
		board[7].spaceIsEmpty = false;
		board[8].numberOnBoard = "X";
		board[8].spaceIsEmpty = false;


	}

/*	// Check the number of cells that are empty
	private ArrayList<Integer> numberOfAvailableCells(Cell[] board)
	{
		ArrayList<Integer> numberOfEmptyCells = new ArrayList<>();
		int numberOnBoard = 1;
		for (Cell cell : board)
		{
			if(cell.spaceIsEmpty){
				numberOfEmptyCells.add(numberOnBoard += 1);
			}
		}
		return numberOfEmptyCells;
	}*/


	int[] minimax(int depth, Board board, String currentPlayer)
	{
		ArrayList<Cell> availableMoves = this.numberOfAvailableCells(board.cells);
		// Check to see if its a tie, win, or lose
		// Win
		if (this.aiHasWon(board.cells))
		{
			return new int[]{10 - depth, 387565234};
		}
		// Lose
		else if (this.playerHasWon(board.cells))
		{

			return new int[]{depth - 10, 35234};
		}
		// Tie
		else if (availableMoves.isEmpty())
		{
			return new int[]{0, 3875234};
		}

		ArrayList<int[]> scores = new ArrayList<>();
		for (int i = 0; i < availableMoves.size(); i++)
		{
			// check to see if its the AI's turn
			if (currentPlayer.equals("O"))
			{
				Board newBoard = new Board(board);
				if (newBoard.cells[Integer.parseInt(availableMoves.get(i).numberOnBoard)- 1].spaceIsEmpty)
				{
					newBoard.move(Integer.parseInt(availableMoves.get(i).numberOnBoard), currentPlayer,newBoard.cells);

					scores.add(minimax(depth += 1, newBoard, playerHuman));
				}
			}
			else if (currentPlayer.equals("X"))
			{
				Board newBoard = new Board(board);
				if (newBoard.cells[Integer.parseInt(availableMoves.get(i).numberOnBoard) - 1].spaceIsEmpty)
				{
					newBoard.move(Integer.parseInt(availableMoves.get(i).numberOnBoard), currentPlayer,newBoard.cells);
					scores.add(minimax(depth += 1, newBoard, playerAI));
				}
			}
		}

		if (currentPlayer.equals("O"))
		{
			int maxScore = Integer.MIN_VALUE;
			int maxIndex = 0;
			for (int i = 0; i < scores.size(); i++)
			{
				if(scores.get(i)[0] > maxScore){
					maxScore = scores.get(i)[0];
					maxIndex = Integer.parseInt(availableMoves.get(i).numberOnBoard);;
				}
			}
			return new int[]{maxScore, maxIndex};
		}
		else
		{
			int minScore = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 0; i < scores.size(); i++)
			{
				if(scores.get(i)[0] < minScore){
					minScore = scores.get(i)[0];
					minIndex = Integer.parseInt(availableMoves.get(i).numberOnBoard);
				}
			}
			return new int[]{minScore, minIndex};
		}
	}

	/*	class MaxComparator implements Comparator<Integer>
		{
			public int compare(Integer a, Integer b) {
				if (a > b) {
					return - 1;
				}
				if (a < b ) {
					return 1;
				}
				return 0;
			}
		}

		class MinComparator implements Comparator<Integer>
		{
			public int compare(Integer a, Integer b) {
				if (a < b) {
					return 1;
				}
				if (a > b ) {
					return -1;
				}
				return 0;
			}
		}*/
	// Check to see if the AI has won
	private boolean aiHasWon(Cell[] board)
	{
		// Top Across
		if (board[0].numberOnBoard.equals("O") && board[1].numberOnBoard.equals("O") && board[2].numberOnBoard.equals("O"))
		{
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O"))
		{
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O"))
		{
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("O") && board[3].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"))
		{
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			return true;
		}
		// Top Right to Bottom Left
		else
		{ return board[2].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"); }
	}

	// Check to see if the Player has won
	private boolean playerHasWon(Cell[] board)
	{
		// Top Across
		if (board[0].numberOnBoard.equals("X") && board[1].numberOnBoard.equals("X") && board[2].numberOnBoard.equals("X"))
		{
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X"))
		{
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X"))
		{
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("X") && board[3].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"))
		{
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			return true;
		}
		// Top Right to Bottom Left
		else
		{ return board[2].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"); }
	}


	void printBoard(Cell[] board)
	{
		System.out.print(" " + cells[0].numberOnBoard + "  | ");
		System.out.print(" " + cells[1].numberOnBoard + "  | ");
		System.out.print(" " + cells[2].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + cells[3].numberOnBoard + "  | ");
		System.out.print(" " + cells[4].numberOnBoard + "  | ");
		System.out.print(" " + cells[5].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + cells[6].numberOnBoard + "  | ");
		System.out.print(" " + cells[7].numberOnBoard + "  | ");
		System.out.print(" " + cells[8].numberOnBoard);
		System.out.println();
	}
}


