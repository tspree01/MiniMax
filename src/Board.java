import java.util.ArrayList;

public class Board {
	private final int Rows = 3;
	private final int Columns = 3;
	int[][] squares = new int[Rows][Columns];
	Board prev;
	ArrayList<Integer> scoreList = new ArrayList<>();

	Board(){

	}

	Board(int Rows, int Column){
		squares = new int[Rows][Columns];
	}

	//copy constructor
	public Board(Board _prev) {
		this.prev = _prev;
		System.arraycopy(_prev.squares,0,this.squares,0,_prev.squares.length);
	}
	//set all the cells to -1 which is empty
	void setupBoard(){
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Columns; j++) {
				squares[i][j] = -1;
			}
		}
	}

	public void printBoard() {

		System.out.print(" 1 " + " | ");
		System.out.print(" 2 " + " | ");
		System.out.print(" 3 ");
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" 4 " + " | ");
		System.out.print(" 5 " + " | ");
		System.out.print(" 6 ");
		System.out.println();
		System.out.println("----+-----+----");
		System.out.print(" 7 " + " | ");
		System.out.print(" 8 " + " | ");
		System.out.print(" 9 ");
		System.out.println();
		System.out.print("Your Move: ");
	}


}


