import java.util.*;
import java.io.File;
import java.util.Arrays;

public class IntervalScheduling {

	// int arrays for start/end of jobs
	private static int[] start;
	private static int[] end;
	
	// contains index of the optimalSet; 
	// index of the sorted array
	private static int[] optimalSet;

	public static void main ( String args[] ) throws Exception {
		Scanner sc = new Scanner(new File("isp.txt"));
		int numOfJobs = sc.nextInt();	
 		start = new int[numOfJobs];
 		end = new int[numOfJobs];
 		optimalSet = new int[numOfJobs];

		// move to the next line
		sc.nextLine();

		// get all job data
		for (int i = 0; i < numOfJobs; ++i) {
			String line = sc.nextLine();
			String[] schedule = line.split(" ");
			start[i] = Integer.parseInt(schedule[0]);	
			end[i] = Integer.parseInt(schedule[1]);	
		}

		// sort job data array; based on earliest finish time
		ExtendedQuickSort.sort(end, start);

		// System.out.println(Arrays.toString(start));
		// System.out.println(Arrays.toString(end));
		
		// loop through job data; store all compatible
		int count = 0;
		for (int i = 0; i < numOfJobs; ++i) {
			if (count == 0) {
				optimalSet[count] = i;
				count++;
			} 
			// this is the isCompatible part
			else if (start[i] >= end[ optimalSet[count-1] ]) {
				optimalSet[count] = i;
				count++;
			}
		}

		// System.out.println(Arrays.toString(optimalSet));
		System.out.println(count);

		sc.close();
	}
}