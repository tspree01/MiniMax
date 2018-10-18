import java.util.ArrayList;

class Board
{
	Cell[] cells;
	int numberOfMoves = 0;

	Board()
	{
		this.cells = new Cell[9];
		for (int i = 0; i < cells.length; i++)
		{
			cells[i] = new Cell(String.valueOf(i + 1), true);
		}
	}

	//copy constructor
	private Board(Board board)
	{
		this.cells = new Cell[9];
		for (int i = 0; i < this.cells.length; i++)
		{
			this.cells[i] = new Cell(String.valueOf(board.cells[i].numberOnBoard), board.cells[i].spaceIsEmpty);
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

	void setupBoard(Cell[] board)
	{
		board[0].numberOnBoard = "1";
		board[0].spaceIsEmpty = false;
		board[1].numberOnBoard = "2";
		//board[1].spaceIsEmpty = false;
		board[2].numberOnBoard = "3";
		//board[2].spaceIsEmpty = false;
		board[3].numberOnBoard = "4";
		board[4].numberOnBoard = "5";
		board[4].spaceIsEmpty = true;
		board[5].numberOnBoard = "6";
		//board[5].spaceIsEmpty = false;
		board[6].numberOnBoard = "O";
		board[6].spaceIsEmpty = false;
		board[7].numberOnBoard = "8";
		//board[7].spaceIsEmpty = false;
		board[8].numberOnBoard = "9";
		//board[8].spaceIsEmpty = false;
	}

	int[] minimax(int depth, Board board, String currentPlayer, boolean maximizePlayer, int alpha, int beta)
	{
		ArrayList<Cell> availableMoves = this.numberOfAvailableCells(board.cells);
		int maxIndex = 0;
		int minIndex = 0;
		// Check to see if its a tie, win, or lose
		// Win
		if (this.aiHasWon(board.cells))
		{
			//printBoard(board.cells);
			//int[1] = score
			//int[2] = index of best move
			//int[3] = alpha
			//int[4] = beta
			return new int[]{10 - depth, 387565234, Integer.MIN_VALUE, Integer.MAX_VALUE};
		}
		// Lose
		else if (this.playerHasWon(board.cells))
		{
			//printBoard(board.cells);
			return new int[]{depth - 10, 35234, Integer.MIN_VALUE, Integer.MAX_VALUE};
		}
		// Tie
		else if (availableMoves.isEmpty())
		{
			//printBoard(board.cells);
			return new int[]{0, 3875234, Integer.MIN_VALUE, Integer.MAX_VALUE};
		}

			ArrayList<int[]> scores = new ArrayList<>();

		if(maximizePlayer)
		{
			int[] score = new int[2];
			for (int i = 0; i < availableMoves.size(); i++)
			{
				// check to see if its the AI's turn
				//if (currentPlayer.equals("O"))
				//{
					Board newBoard = new Board(board);
					//	if (newBoard.cells[Integer.parseInt(availableMoves.get(i).numberOnBoard) - 1].spaceIsEmpty)
					//{
					newBoard.move(Integer.parseInt(availableMoves.get(i).numberOnBoard), currentPlayer, newBoard.cells);
					numberOfMoves++;

					String playerHuman = "X";
					score = minimax(depth + 1, newBoard, playerHuman, false, alpha, beta);

					if(score[0] > alpha){
						alpha = score[0];
						maxIndex = i;
					}

					if (alpha >= beta)
					{
						break;
					}
					//}
				//}
/*				else
				{
					Board newBoard = new Board(board);
					//if (newBoard.cells[Integer.parseInt(availableMoves.get(i).numberOnBoard) - 1].spaceIsEmpty)

					//{
					newBoard.move(Integer.parseInt(availableMove.numberOnBoard), currentPlayer, newBoard.cells);
					String playerAI = "O";
					scores.add(minimax(depth + 1, newBoard, playerAI, true, alpha, beta));
					if (alpha >= beta)
					{
						break;
					}
					//}
				}*/
			}

		}
		else{
			int[] score = new int[2];
			for (int i = 0; i < availableMoves.size(); i++)
			{
				Board newBoard = new Board(board);
				//if (newBoard.cells[Integer.parseInt(availableMoves.get(i).numberOnBoard) - 1].spaceIsEmpty)

				//{
				newBoard.move(Integer.parseInt(availableMoves.get(i).numberOnBoard), currentPlayer, newBoard.cells);
				numberOfMoves++;

				String playerAI = "O";
				score = minimax(depth + 1, newBoard, playerAI, true, alpha, beta);

				if(score[0] < beta){
					beta = score[0];
					minIndex = i;
				}

				if (alpha >= beta)
				{
					break;
				}
			}
		}
		if(maximizePlayer){
			return new int[]{alpha, Integer.parseInt(availableMoves.get(maxIndex).numberOnBoard)};

		}else{
			return new int[]{beta, Integer.parseInt(availableMoves.get(minIndex).numberOnBoard)};
		}
/*		if (currentPlayer.equals("O"))
		{
			int maxScore = -10000;
			int maxIndex = 0;
			for (int i = 0; i < scores.size(); i++)
			{
				if (scores.get(i)[0] > maxScore)
				{
					maxScore = scores.get(i)[0];
					maxIndex = i;
				}
				if(scores.get(i)[0] > alpha){
					alpha = scores.get(i)[0];
					maxIndex = i;
				}
			}
			return new int[]{maxScore, Integer.parseInt(availableMoves.get(maxIndex).numberOnBoard), alpha, beta};
		}
		else
		{
			int minScore = 10000;
			int minIndex = 0;
			for (int i = 0; i < scores.size(); i++)
			{
				if (scores.get(i)[0] < minScore)
				{
					minScore = scores.get(i)[0];
					minIndex = i;
				}
				if(scores.get(i)[0] < beta){
					beta = scores.get(i)[0];
					minIndex = i;
				}
			}
			return new int[]{minScore, Integer.parseInt(availableMoves.get(minIndex).numberOnBoard), alpha, beta};
		}*/
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

	void printBoard(Cell[] board)
	{
		System.out.print(" " + board[0].numberOnBoard + "  | ");
		System.out.print(" " + board[1].numberOnBoard + "  | ");
		System.out.print(" " + board[2].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + board[3].numberOnBoard + "  | ");
		System.out.print(" " + board[4].numberOnBoard + "  | ");
		System.out.print(" " + board[5].numberOnBoard);
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" " + board[6].numberOnBoard + "  | ");
		System.out.print(" " + board[7].numberOnBoard + "  | ");
		System.out.print(" " + board[8].numberOnBoard);
		System.out.println();
	}
}


