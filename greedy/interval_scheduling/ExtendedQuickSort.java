import java.util.*;


/**
 * Accepts two arrays, keys and values
 * and sorts the two array according to the keys array
 */
public class ExtendedQuickSort {

	private static int[] keys;
	private static int[] values;

	public static void sort(int[] k, int[] v) {
		keys = k;
		values = v;
		quickSort(0, keys.length-1);
	}

	/*
     * This quickSort chooses the last item in the array as its 'pivot'
	 * 
	 * p - i = lower values
	 * i+1 to j-1 = higher values
	 * j to r = unprocessed values
	 */
	private static void quickSort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			quickSort(p, q-1);
			quickSort(q+1, r);
		}
	}

	private static int partition(int p, int r) {
		int i = p - 1;
		for (int j=p; j<r; j++)	 {
			if (keys[j] < keys[r]) {
				i++;
				swap(i, j);
			}
		}
		swap(i+1, r);
		return i+1; // this is the index of the pivot
	}

	private static void swap(int i, int j) {
		int temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;

		temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}
}