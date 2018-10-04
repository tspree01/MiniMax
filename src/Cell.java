public class Cell {
	int row;
	int column;
	int numberOnBoard;
	boolean spaceIsEmpty;

	public Cell(int row, int column, int numberOnBoard, boolean spaceIsEmpty) {
		this.row = row;
		this.column = column;
		this.numberOnBoard = numberOnBoard;
		this.spaceIsEmpty = spaceIsEmpty;
	}
}
