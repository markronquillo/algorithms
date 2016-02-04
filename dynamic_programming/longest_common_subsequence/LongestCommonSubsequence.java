/*
 * Separate class that handles the computation of each given set of strings
 */ 
public class LongestCommonSubsequence 
{

	private String firstString;
	private String secondString;
	private int fLength;
	private int sLength;
	private int[][] memo;	
	private String longestCommonSubsequence;

	public LongestCommonSubsequence(String firstStr, String secondStr) {
		this.firstString = firstStr;
		this.secondString = secondStr;

		this.fLength = firstString.length();
		this.sLength = secondString.length();

		// initialize m by n memoization array
		this.memo = new int[fLength+1][sLength+1];

		// fill the memo table start at 1,1
		// row 0 and column 0 has zero values by default
		for (int i=1; i <= fLength; i++) {
			for(int j=1; j <= sLength; j++) {
				this.LCS(i, j);
			}
		}

		// get a lcs -- trace from the memo array
		this.longestCommonSubsequence = this.traceLCS();

		// this.printMemo();
	}

	@Override	
	public String toString() {
		return String.format("Case: '%s'- %d", 
			this.longestCommonSubsequence, this.memo[this.fLength][this.sLength]);
	}	

	/*
	 *	Calculates the length of LCS given the index of the 
	 *	first and second string.
	 *	
	 *	params:
	 *		i <- index for firstString
	 *		j <- index for secondString
	 */
	private int LCS(int i, int k) {

		if (memo[i][k] == 0 && i!=0 && k!=0) 
		{
			if (this.firstString.charAt(i-1) == this.secondString.charAt(k-1))
			{
				memo[i][k] = this.LCS(i-1, k-1) + 1;
			}
			else 
			{
				memo[i][k] = Math.max(this.LCS(i-1, k), this.LCS(i, k-1));
			}
			return memo[i][k];
		} 
		else 
		{
			return memo[i][k];
		}
	}

	/*
	 *	Trace the memo table and generate an instance of the LCS
	 */
	private String traceLCS() {
		StringBuilder sb = new StringBuilder();

		for(int x=this.fLength, y=this.sLength; x!=0 && y!=0;) 
		{
			// look at the top - check if it equal to the current cell value
			if (memo[x][y] == memo[x][y-1])
			{
				y--;
			}
			// if not, then check left cell
			else if (memo[x][y] == memo[x-1][y])
			{
				x--;
			}
			// if both are not equal then save current character value
			// then move diagonally towards top-left
			else {
				sb.append(firstString.charAt(x-1));
				x--;
				y--;
			}
		}
		return sb.reverse().toString();
	}

	/*
	 * This just prints the table memo
	 */
	private void printMemo() {
		for (int i=0; i <= fLength; i++) 
		{
			for(int j=0; j <= sLength; j++) 
			{
				System.out.print( String.format("%d ", this.memo[i][j]) );
			}
			System.out.println("");
		}
	}
}