package leetCode;

public class FindIslands {

	public FindIslands() {
		// TODO Auto-generated constructor stub
	}

	public int numIslands(char[][] grid) {

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					islandChecker(grid, i, j);
				}
			}
		}

	}

	public void islandChecker(char[][] grid, int i, int j) {
		
		
		grid[i][j]='0';
		if(i+1<grid.length)//check boundary vertical down
		{
			if(grid[i+1][j]=='1')//check vertical down
			{
				grid[i+1][j]='0';
				islandChecker(grid, i+1, j);
			}
		}
		if(i-1>=0)//check boundary vertical up
		{
			if(grid[i-1][j]=='1')//check vertical up
			{
				grid[i-1][j]='0';
				islandChecker(grid, i-1, j);
			}
		}
		if(j+1<grid[i].length)//check boundary horizontal right
		{
			if(grid[i][j+1]=='1')//check horizontal right
			{
				grid[i][j+1]='0';
				islandChecker(grid, i, j+1);
			}
		}
		if(j-1>=0)//check the boundary horizontal left
		{
			if(grid[i][j-1]=='1')//check horizontal left
			{
				grid[i][j-1]='0';
				islandChecker(grid, i, j-1);
			}
		}
		return;
		
	}

}
