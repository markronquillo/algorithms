import java.util.*;
import java.io.File;
import java.util.Arrays;


public class HeapSort extends SortingAlgorithm {

	public HeapSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		// Phase 1: build heap from the array
		buildHeap(arr);

		// Phase 2: start sorting
		int currentMaxIndex = arr.length - 1;

		while (currentMaxIndex > 0)
		{
			exchange(arr, 0, currentMaxIndex);
			currentMaxIndex--;
			heapify(arr, 0, currentMaxIndex);
		}
	}

	/**
	 *	Make the array input to represent a heap tree
	 */
	private void buildHeap(int[] A) 
	{
		for(int i=A.length-1; i >= 0; i--)
		{
			heapify(A, i);
		}
	}

	/**
	 *	Push down an index until it satisfy the heap property
	 */
	private void heapify(int[] A, int ind, int maxIndex)
	{
		int[] c = getChildrenIndices(ind);

		int j = -1;
		if (c[0] > maxIndex)
		{
			return;
		}
		else if (c[0] <= maxIndex)
		{
			// if there are two children; get the index of the largest value
			if (c[1] <= maxIndex) 
			{
				if ( Math.max(A[c[0]], A[c[1]]) == A[c[0]] )
				{
					j = c[0];
				}
				else {
					j = c[1];
				}
			}
			else {
				j = c[0];
			}
		}

		if ( A[ind] < A[j] )
		{
			exchange(A, ind, j);
			heapify(A, j, maxIndex);
		}
	}

	/**
	 * Overload for the heapify just for optional parameter for max_index
	 */	
	private void heapify(int[] A, int ind)
	{
		heapify(A, ind, A.length - 1);
	}

	/**
	 * Calculate the children indices for the heap-tree
	 */
	private int[] getChildrenIndices(int ind)
	{
		int base = (ind + 1) * 2;
		int[] c = {base-1, base};
		return c;
		// return {base, base+1};
	}

	/**
	 * Calculate the parent index
	 */
	private int getParentIndex(int ind)	
	{
		if (ind == 0) return -1;
		return (int) ( Math.floor( (ind-1) / 2 ) );
	}

	/**
	 * Given two indices value and an array, exchange the values
	 */
	private void exchange(int[] A, int i, int k)
	{
		int temp = A[i];
		A[i] = A[k];
		A[k] = temp;
	}

	
}