import javax.swing.*;
import java.util.ArrayList;

public class Board
{
	private final int Rows = 3;
	private final int Columns = 3;
	//ArrayList<Cell[]> squares = new ArrayList<>();
	Cell[] squares = new Cell[9];
	Board prev;
	ArrayList<Integer> scoreList = new ArrayList<>();


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
		//System.arraycopy(_prev.squares, 0, this.squares, 0, _prev.squares.length);
	}

	// place an X or an O where the current player selected
	void move(int userInput, String currentPlayer){
		this.squares[userInput-1].numberOnBoard = currentPlayer;
	}

	//set all the cells to blank
	void setupBoard()
	{
		for (int i = 0; i < squares.length; i++)
		{
			squares[i] = new Cell(String.valueOf(i+1), true);
		}
	}

	public void printBoard()
	{
		System.out.print(" " + squares[0].numberOnBoard + "  | ");
		System.out.print(" " + squares[1].numberOnBoard + "  | ");
		System.out.print(" " + squares[2].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + squares[3].numberOnBoard + "  | ");
		System.out.print(" " + squares[4].numberOnBoard + "  | ");
		System.out.print(" " + squares[5].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + squares[6].numberOnBoard + "  | ");
		System.out.print(" " + squares[7].numberOnBoard + "  | ");
		System.out.print(" " + squares[8].numberOnBoard);
		System.out.println();
		System.out.println("Your Move: ");
	}
}


