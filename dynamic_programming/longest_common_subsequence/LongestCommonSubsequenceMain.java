import java.util.*;
import java.io.File;
import java.util.Arrays;

/*
 * javac LongestCommonSubsequenceMain.java && java LongestCommonSubsequence
 */
public class LongestCommonSubsequenceMain {
	
	public static void main(String[] args) throws Exception {
		// read file
		Scanner sc = new Scanner(new File("lcs.txt"));

		int numCases = sc.nextInt();	

		// move to the next line
		sc.nextLine();

		for (int i = 0; i < numCases; ++i) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");

			LongestCommonSubsequence l = 
				new LongestCommonSubsequence(parts[0], parts[1]);
			System.out.println( l.toString() );
		}
		sc.close();
	}
}
