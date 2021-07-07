package leetCode;

import java.util.Queue;

public class FindIslandQueue {

	public FindIslandQueue() {
		// TODO Auto-generated constructor stub
	}

	private final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslands(char grid[][]) {

		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					islandChecker(cols, rows, i, j, grid);
				}
			}
		}
		return count;
	}

	private void islandChecker(int cols, int rows, int i, int j, char[][] grid) {
		Queue<Integer> queue = new LinkedList<>();
		// conversion form 2d --> 1D = row * #col +col
		// 1d--> 2d = Result / #col = row
		// Result % #col = col

		queue.add((i * cols) + j);
		grid[i][j] = '0';

		while (!queue.isEmpty()) {
			int index = queue.poll();
			int row = index / cols;
			int col = index % cols;

			for (int[] directions : DIRECTIONS) {
				int y = directions[0] + row;
				int x = directions[1] + col;
				if (y >= 0 && y < rows && x >= 0 && x < cols) {
					if (grid[y][x] == '1') {
						grid[y][x] = '0';
						queue.add((y * cols) + x);
					}

				}
			}

		}

	}
}
