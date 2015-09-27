import java.util.*;
import java.io.File;
import java.util.Arrays;

public class SortingBenchmarker {
	static final String DELIMITER = "\t";
	static final int NUM_EXPERIMENTS = 30;
	
	public static void main ( String[] args ) throws Exception
	{
		Scanner sc = new Scanner(new File("SortingInput.txt"));

		int numCases = sc.nextInt();
		
		for (int i = 0; i < numCases; ++i)
			benchmark(sc);
		
		sc.close();
	}
	
	
	public static void benchmark (Scanner sc)
	{
		int numItems = sc.nextInt();
		int[] arrOrig = new int[numItems];
		
		// store contents to an array
		for (int i = 0; i < numItems; ++i)
		{
			arrOrig[i] = sc.nextInt();
		}

		// SortingAlgorithm sSort = new SelectionSort( arrOrig, numItems );
		// SortingAlgorithm iSort = new InsertionSort( arrOrig, numItems );
		SortingAlgorithm mSort = new MergeSort( arrOrig, numItems );
		// SortingAlgorithm shSort = new ShellSort( arrOrig, numItems );
		// ((ShellSort)shSort).setSequence( new int[] {4, 2, 1} );
		SortingAlgorithm heapSort= new HeapSort( arrOrig, numItems);
		SortingAlgorithm quickSort= new QuickSort( arrOrig, numItems);
		SortingAlgorithm radixSort= new RadixSort( arrOrig, numItems);

		// System.out.printf("Selection Sort : %d %s %.2e \n", numItems, DELIMITER, sSort.getAverageRunTime(NUM_EXPERIMENTS));
		// System.out.printf("Insertion Sort : %d %s %.2e \n", numItems, DELIMITER, iSort.getAverageRunTime(NUM_EXPERIMENTS));
		System.out.printf("Merge Sort     : %d %s %.2e \n", numItems, DELIMITER, mSort.getAverageRunTime(NUM_EXPERIMENTS));
		// System.out.printf("Shell Sort     : %d %s %.2e \n", numItems, DELIMITER, shSort.getAverageRunTime(NUM_EXPERIMENTS));
		System.out.printf("Heap Sort     : %d %s %.2e \n", numItems, DELIMITER, heapSort.getAverageRunTime(NUM_EXPERIMENTS));
		System.out.printf("Quick Sort     : %d %s %.2e \n", numItems, DELIMITER, quickSort.getAverageRunTime(NUM_EXPERIMENTS));
		System.out.printf("Radix Sort     : %d %s %.2e \n", numItems, DELIMITER, radixSort.getAverageRunTime(NUM_EXPERIMENTS));
		
	}
	
}

