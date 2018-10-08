import java.util.ArrayList;

public class Board
{
	private final int Rows = 3;
	private final int Columns = 3;
	//ArrayList<Cell[]> squares = new ArrayList<>();
	Cell[] cells = new Cell[9];
	Board prev;
	int miniMaxScore = 0;


	Board()
	{
	}

	Board(int Rows, int Column)
	{
		//squares = new String[Rows][Columns];
	}

	//copy constructor
	public Board(Board _prev)
	{
		this.prev = _prev;
		System.arraycopy(_prev.cells, 0, this.cells, 0, _prev.cells.length);
	}

	// place an X or an O where the current player selected
	void move(int userInput, String currentPlayer)
	{
		this.cells[userInput - 1].numberOnBoard = currentPlayer;
		this.cells[userInput - 1].spaceIsEmpty = false;
	}

	ArrayList<Cell> availableCells(Cell[]board){
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
	void setupBoard()
	{
		for (int i = 0; i < cells.length; i++)
		{
			cells[i] = new Cell(String.valueOf(i + 1), true);
		}
	}

	// Check the number of cells that are empty
	private int numberOfAvailableCells(Cell[] board)
	{
		int numberOfAvailableSpaces = 0;
		for (Cell cell : board)
		{
			if (cell.spaceIsEmpty)
			{
				numberOfAvailableSpaces++;
			}
		}
		return numberOfAvailableSpaces;
	}

	int minimax(int depth, Board board, String currentPlayer)
	{
		//ArrayList<Integer> scores = new ArrayList<>();
		// Check to see if its a tie, win, or lose
		// Win
		if (this.aiHasWon(board.cells))
		{
			return 10 - depth;
		}
		// Lose
		if (this.playerHasWon(board.cells))
		{
			return depth - 10;
		}
		// Tie
		if(numberOfAvailableCells(board.cells) == 0){
			return 0;
		}


		for (int i = 0; i < board.cells.length; i++)
		{
			if(board.cells[i].spaceIsEmpty){
				Board newBoard = new Board(board);
				newBoard.move(i,currentPlayer);

			}

		}

	}


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


	void printBoard()
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
		System.out.println("Your Move: ");
	}
}


