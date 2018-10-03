public class Board {
	private final int ROWS = 3;
	private final int COLOUMS = 3;
	int[][] squares = new int[ROWS][COLOUMS];

	Board(){

	}

	public void printToConsole() {

		System.out.println("Board: ");

		for (int i = 0; i < ROWS; ++ i) {
			for (int j = 0; j < COLOUMS; j++) {

				System.out.print(this.squares[i][j]);
				System.out.print( " | ");
			}
			System.out.println();

			System.out.println( "---+---+---");
		}
	}
}
