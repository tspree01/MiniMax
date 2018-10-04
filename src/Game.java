import java.util.Random;
import java.util.Scanner;

public class Game
{
	private final int Rows = 3;
	private final int Colums = 3;
	private Scanner sc = new Scanner(System.in);
	Board board;

	public static void main(String[] args)
	{
		new Game().run();
	}

	void run()
	{
		board = new Board(Rows, Colums);
		board.setupBoard();
		board.printBoard();
		//board.setupCells();
		//board.printToConsole();

		//Get the user's move
		int humansInput = sc.nextInt();
	}
}
