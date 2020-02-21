import java.util.Random;
import java.util.Scanner;

public class Game
{
	private Scanner sc = new Scanner(System.in);
	private boolean computerHasWon = false;
	private boolean playerHasWon = false;

	public static void main(String[] args)
	{
		Game game = new Game();
		int input = game.displayMenu();
		if(input == 1)
		{
			game.ticTacToe();
		}
		else if(input == 2){
			game.globalThermalNuclearWar();
		}
		else {
			System.out.println("Please pick either Tic-tac-toe or Global Thermal Nuclear War");
			input = game.displayMenu();
			if(input == 1)
			{
				game.ticTacToe();
			}
			else if(input == 2){
				game.globalThermalNuclearWar();
			}
		}
	}

	private void globalThermalNuclearWar(){
		Random r = new Random();
		for (int i = 0; i < 100 ; i++)
		{
			System.out.print(Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()) +Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()) + Integer.toBinaryString(r.nextInt()));
			System.out.println();
		}

		System.out.println();
		System.out.println("I'm sorry their appears to be an error with Global Thermal Nuclear War error code (0x87df2ee7)");

		System.out.println("Lets play Tic-tac-toe instead");
		System.out.println();

		new Game().ticTacToe();
	}

	private int displayMenu(){
		System.out.println("What game would you like to play? ");
		System.out.println("1) Tic-tac-toe.");
		System.out.println("2) Global Thermal Nuclear War.");
		System.out.print("Choice: ");
		return sc.nextInt();
	}
	private void ticTacToe()
	{
		int[] bestMove;
		Board board = new Board();
		//board.setupBoard(board.cells);

		while (true)
		{
			if (!currentPlayerWon(board.cells))
			{
				//board.printBoard(board.cells);
				board.printBoard(board.cells);
				System.out.print("Your Move: ");

				//Get the user's move
				int userInput = sc.nextInt();
				String playerHuman = "X";
				board.move(userInput, playerHuman, board.cells);
				if(! board.numberOfAvailableCells(board.cells).isEmpty())
				{
					String playerAI = "O";
					bestMove = board.alphabeta(0, board, playerAI, Integer.MIN_VALUE, Integer.MAX_VALUE);
					board.minimax(0,board,playerAI);
					// best move[1] isnt getting the cell that bestmove[1] points too like index 1 can be cell 3 of available moves
					board.move(bestMove[1], playerAI, board.cells);
					System.out.println();
				}
				else{
					System.out.println("Alpha-Beta pruning moves predicted: " + board.alphaBetaPruningNumberOfMoves);
					System.out.println("Mini-Max moves predicted: " + board.miniMaxNumberOfMoves);
					System.out.println("Draw");
					break;
				}

				//board.move(userInput, playerHuman, actuallyBoard.cells);
			}
			else
			{
				board.printBoard(board.cells);
				System.out.println("Alpha-Beta pruning moves predicted: " + board.alphaBetaPruningNumberOfMoves);
				System.out.println("Mini-Max moves predicted: " + board.miniMaxNumberOfMoves);
				if (computerHasWon)
				{
					System.out.println("AI Won");
				}
				else if (playerHasWon)
				{
					System.out.println("Human Won");
					System.out.println("Wait what Human Won. Wow! im an idiot!");
				}
				else
				{
					System.out.println("Its a Draw");
				}
				break;
			}
		}
	}



	// Check to see if the AI has won
	private boolean currentPlayerWon(Cell[] board)
	{
		// Top Across
		boolean draw = false;
		if (board[0].numberOnBoard.equals("O") && board[1].numberOnBoard.equals("O") && board[2].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[7].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("O") && board[3].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("O") && board[5].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[8].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		// Top Right to Bottom Left
		else if (board[2].numberOnBoard.equals("O") && board[4].numberOnBoard.equals("O") && board[6].numberOnBoard.equals("O"))
		{
			computerHasWon = true;
			playerHasWon = false;
			return true;
		}
		// Top Across
		else if (board[0].numberOnBoard.equals("X") && board[1].numberOnBoard.equals("X") && board[2].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		//Middle Across
		else if (board[3].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		// Bottom Across
		else if (board[6].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		//Middle Down
		else if (board[1].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[7].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		// Right Down
		else if (board[0].numberOnBoard.equals("X") && board[3].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		// Left Down
		else if (board[2].numberOnBoard.equals("X") && board[5].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		//Top Left to Bottom Right
		else if (board[0].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[8].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		// Top Right to Bottom Left
		else if (board[2].numberOnBoard.equals("X") && board[4].numberOnBoard.equals("X") && board[6].numberOnBoard.equals("X"))
		{
			playerHasWon = true;
			computerHasWon = false;
			return true;
		}
		else
		{
			computerHasWon = false;
			playerHasWon = false;
			return false;
		}
	}
}
