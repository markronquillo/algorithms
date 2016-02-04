import java.util.*;

/*
 * Given a price list and the length of a rod
 * Provide the optimal way to cut the rod so that we maximize our profit
 *  
 */
public class RodCut {

	// prices for length 1 to 10
	private static int[] price = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

	// this will hold the cache result
	private static int[] memoCost;

	public static void main( String[] args ) throws Exception {
		int n = 8;
		memoCost = new int[10];

		// Bottom-up compute for optimal cost
		// given length from 1 to n
		for (int i=1; i<=n; i++) {
			cutRod(i); // compute optimal cost and cache the result
		}
		System.out.println(memoCost[n-1]);
	}

	private static int cutRod(int length) {
		// default value to be overriden by max value
		int q = -1;

		// if length is zero then the cost is obviously zero
		if (length == 0) return 0;

		// if it is already computed then return
		if (memoCost[length-1] > 0) return memoCost[length-1];

		for (int i=1; i<=length; i++) {
			// Combinations cut plus optimal of remainder
			q = Math.max(q, price[i-1] + cutRod(length-i));
		}
		memoCost[length-1] = q;
		return q;
	}


}