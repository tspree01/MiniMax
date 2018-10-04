import javax.swing.*;
import java.util.ArrayList;

public class Board
{
	private final int Rows = 3;
	private final int Columns = 3;
	//int[][] cells = new int[Rows][Columns];
	ArrayList<Cell[]> squares = new ArrayList<>();
	//Cell[] cell = new Cell[Columns];
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



	//set all the cells to blank
	void setupBoard()
	{
		int numberOnBoard = 1;

		for (int i = 0; i < Rows; i++)
		{
			squares.add(new Cell[Columns]);
			for (int j = 0; j < Columns; j++)
			{

				squares.get(i)[j] = new Cell(i, j,String.valueOf(numberOnBoard++), true);
			}
		}
	}

	public void printBoard()
	{
		System.out.print(" " + squares.get(0)[0].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(0)[1].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(0)[2].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + squares.get(1)[0].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(1)[1].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(1)[2].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + squares.get(2)[0].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(2)[1].numberOnBoard + "  | ");
		System.out.print(" " + squares.get(2)[2].numberOnBoard);
		System.out.println();
		System.out.print("Your Move: ");
	}
}


