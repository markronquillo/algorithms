import java.util.*;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	// 0, 2, 6, 9, 11, 15. -- answer
	private static int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

	private static int[] memo;

	public static void main(String[] args) throws Exception {

		memo = new int[sequence.length];

		// Bottom-up approach
		for (int i=0; i<sequence.length; i++) {
			getLongestIncreasingSubsequenceCount(i);
		}

		// ideally we need to search first the array memo
		// to get the index with the maximum value.
		// but this time we'll just use the last index because we know it holds 
		// the length of the LIS
		System.out.println( backtrackSequence(sequence.length-1) );
	}

	// from the max value index, look for the sequence backwards
	// lets say we have 5 as the max value
	// look for the first value lower than the value of the index
	// and has a memo value of 4, then continue up to memo value of 1
	private static String backtrackSequence(int index) {
		int count = memo[index];
		int[] output = new int[ count ];
		int temp = index;
		output[ count-1 ] = sequence[index];

		while( temp-1 >= 0) {
			if ( sequence[temp-1] <= sequence[index] 
					&& memo[temp-1] == count-1) {
				count=count-1;
				output[count-1] = sequence[temp-1];
			}
			temp--;
		}

		return Arrays.toString(output);
	}

	private static int getLongestIncreasingSubsequenceCount(int index) {
		int max = 0;
		int temp = index;

		while( temp-1 >= 0) {
			if ( sequence[temp-1] <= sequence[index] ) {
				max = Math.max(max, memo[temp-1]);
				// max = memo[temp-1];
			}
			temp--;
		}
		memo[index] = max + 1;
		return memo[index];
	}
}