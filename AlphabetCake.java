package coding_challenge;

class AlphabetCake {
	private int row ;
	private int column ; 
	private char grid[][];
	
	AlphabetCake(int row,int column,char[][] input)
	{
		this.row = row;
		this.column = column;
		this.grid = input;
	}
	
	/*
	 * this function calculates the resultant cake with all the possible
	 * initials...
	 */
	public char[][] solution()
	{
		char temp = '?';
		for (int i = 0;i < row;i++)
		{
			temp = '?';
			for (int j = 0 ; j < column ; j++)
			{
				if (grid[i][j]!='?')
				{
					temp = grid[i][j];//Fill all the empty space by preceding initials
					if (j != 0)
						LeftFill(i,j);//function to fill all the left empty spaces of the first character occurrence in a row
				}
				else
					grid[i][j] = temp;
			}
		}
		
		for (int i = 0;i < column;i++)
		{
			temp = '?';
			for (int j = 0 ; j < row ; j++)
			{
				if (grid[j][i]!='?')
				{
					temp = grid[j][i];
					if (j != 0)
						UpFill(i,j);//function to fill all the up empty spaces of the first character occurrence in a column
				}
				else
					grid[j][i] = temp;
			}
		}
		return grid;
	}
	
	/*
	 * function to fill all the empty space above jth index
	 */
	private void UpFill(int i, int j) {
		// TODO Auto-generated method stub
		char temp = '?';
		for(int k = j;k>=0;k--)
		{
			if (grid[k][i]!='?')
				temp = grid[k][i];
			else
				grid[k][i] = temp;
		}
	}
	
	
	/*
	 * function to fill all the left empty spaces in a row
	 */
	private void LeftFill(int i, int j) {
		// TODO Auto-generated method stub
		char temp = '?';
		for(int k = j;k>=0;k--)
		{
			if (grid[i][k]!='?')
				temp = grid[i][k];
			else
				grid[i][k] = temp;
		}
	}
}

