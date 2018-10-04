import java.util.Random;
import java.util.Scanner;

public class Game
{
	private final int Rows = 3;
	private final int Colums = 3;
	private Scanner sc = new Scanner(System.in);
	final String playerAI = "O";
	final String playerHuman = "X";
	int userInput;
	Board board;

	public static void main(String[] args)
	{
		new Game().run();
	}

	void run()
	{
		board = new Board();
		board.setupBoard();
		for (int k = 0; k < 9; k++)
		{
			board.printBoard();
			//Get the user's move
			userInput = sc.nextInt();
			board.move(userInput,playerHuman);
		}
	}
}
