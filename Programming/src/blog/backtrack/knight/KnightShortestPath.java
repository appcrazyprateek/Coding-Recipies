package blog.backtrack.knight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author PRATEEK
 */
public class KnightShortestPath {

	private static int count = 0;
	private static final int BLANK = -1;
	private static int rowLen;
	private static int colLen;

	private static Queue<Coordinate> queue;
	private static Coordinate endCoordinate;

	public KnightShortestPath(int xend, int yend) {
		endCoordinate = new Coordinate(xend, yend);
	}

	public static void main(String[] args) {

		int[][] board = { { -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 },

				{ -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1, -1, -1 } };

		rowLen = board.length;
		colLen = board[0].length;
		// knightTour(board, 0, 0, 0);
	}

	public static void path(int[][] board, int row, int col, int curr) {
		queue = new LinkedList<Coordinate>();
		queue.add(new Coordinate(row, col));

		while (!queue.isEmpty()) {
			Coordinate popedItem = queue.poll();
			int r = popedItem.row;
			int c = popedItem.col;

			Coordinate[] points = validCoordinates(board, r, c);

			for (Coordinate o : points) {
				if (o != null)
					queue.add(o);
			}
		}
	}

	private static boolean isValid(int[][] board, int row, int col) {
		if (row >= 0 && row < colLen && col >= 0 && col < rowLen
				&& board[row][col] == BLANK)
			return true;
		return false;
	}

	private static void printSol(int[][] board) {
		for (int i = 0; i < colLen; i++) {
			for (int j = 0; j < rowLen; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Done" + count);
	}

	public static Coordinate[] validCoordinates(int[][] board, int row, int col) {
		Coordinate[] points = new Coordinate[8];

		if (isValid(board, row + 2, col + 1))
			points[0] = new Coordinate(row + 2, col + 1);

		if (isValid(board, row + 1, col + 2))
			points[1] = new Coordinate(row + 1, col + 2);

		if (isValid(board, row - 1, col + 2))
			points[2] = new Coordinate(row - 1, col + 2);

		if (isValid(board, row - 2, col + 1))
			points[3] = new Coordinate(row - 2, col + 1);

		if (isValid(board, row - 2, col - 1))
			points[4] = new Coordinate(row - 2, col - 1);

		if (isValid(board, row - 1, col - 2))
			points[5] = new Coordinate(row - 1, col - 2);

		if (isValid(board, row + 1, col - 2))
			points[6] = new Coordinate(row + 1, col - 2);

		if (isValid(board, row + 2, col - 1))
			points[7] = new Coordinate(row + 2, col - 1);

		return points;
	}
}

class Coordinate implements Comparable<Coordinate> {

	public int row;
	public int col;

	public Coordinate() {
		row = 0;
		col = 0;
	}

	public Coordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(Coordinate that) {
		return this.row - that.row - this.col - that.col;
	}
}