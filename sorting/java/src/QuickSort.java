import java.util.*;
import java.io.File;

public class QuickSort extends SortingAlgorithm {

	public QuickSort( int[] arr, int n )
	{
		super( arr, n ); 
	}

	public void sort()
	{
		quickSort(arr, 0, arr.length-1);
	}

	private void quickSort(int[] A, int p, int r) 
	{
		if ( p < r )
		{
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}

	/**
	 * Partitions the array given a range p to r
	 * and returns the index of the pivot
	 */
	private int partition(int[] A, int p, int r)
	{
		int x = A[r];
		int i = p - 1;
		for( int j=p; j < r; j++ ) 
		{
			if (A[j] <= x)
			{
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i+1, r);
		return i+1;
	}

	private void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
}