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
	Board actuallyBoard;
	boolean computerHasWon = false;
	boolean draw = false;
	boolean playerHasWon = false;

	public static void main(String[] args)
	{
		new Game().run();
	}

	void run()
	{
		int[] bestMove;
		board = new Board();
		//board.setupBoard(board.cells);
		//actuallyBoard = new Board();

		while (true)
		{
			if(!currentPlayerWon(board.cells))
			{
				//board.printBoard(board.cells);
				board.printBoard(board.cells);
				System.out.print("Your Move: ");
				//Get the user's move
					userInput = sc.nextInt();
					board.move(userInput, playerHuman, board.cells);
					if(!currentPlayerWon(board.cells))
					{
							bestMove = board.minimax(0, board, playerAI);
							// best move[1] isnt getting the cell that bestmove[1] points too like index 1 can be cell 3 of available moves
							board.move(bestMove[1], playerAI, board.cells);
							System.out.println();
					}

				//board.move(userInput, playerHuman, actuallyBoard.cells);
			}
			else {
				board.printBoard(board.cells);
				if (computerHasWon){
					System.out.println("AI Won");
				}
				else if(playerHasWon){
					System.out.println("Player Won");
				}
				else {
					System.out.println("Draw");
				}
				break;
			}

		}
	}

	// Check to see if the AI has won
	private boolean currentPlayerWon(Cell[] board)
	{
		// Top Across
		if (board[0].numberOnBoard.equals("O") && board[1].numberOnBoard.equals("O") && board[2].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("O") && board[3].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		// Top Right to Bottom Left
		else if (board[2].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			draw = false;
			return true;
		}
		// Top Across
		else if (board[0].numberOnBoard.equals("X") && board[1].numberOnBoard.equals("X") && board[2].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("X") && board[3].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		// Top Right to Bottom Left
		else if(board[2].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			draw = false;
			return true;
		}
		else {
			draw = true;
			computerHasWon = false;
			playerHasWon = false;
			return false;
		}
	}
}
