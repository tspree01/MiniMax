public class Board {
	private final int ROWS = 3;
	private final int COLOUMS = 3;
	int[][] squares = new int[ROWS][COLOUMS];

	Board() {

	}

	public void printToConsole() {

		System.out.println("Board: ");

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
	}
}
