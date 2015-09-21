import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {

	public MergeSort( int[] arr , int n ) 
	{
		super(arr, n);
	}

	public void sort() 
	{
		mSort(arr, 0, arr.length-1);
	}

	/**
	 * Recursively sort the array
	 */
	public void mSort(int[] arrayValue, int low, int high) 
	{
		if (low < high) 
		{
			int mid = (int)Math.floor((high + low) / 2);
			mSort(arrayValue, low, mid);
			mSort(arrayValue, mid+1, high);
			merge(arrayValue, low, mid, high);
		}
	}

	/** 
	 * Merging part of the two sub-arrays
	 */
	public void merge(int[] arrayValue, int low, int mid, int high)
	{
		// compute size of subarrays
		int n1 = mid - low + 1;
		int n2 = high - mid;

		// declare subarrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		// copy values from Main array to subarrays
		for(int i=0; i < n1; i++) 
		{
			L[i] = arrayValue[low+i];
		}
		for(int i=0; i < n2; i++) 
		{
			R[i] = arrayValue[mid + i + 1];
		}

		// declare counters for subarrays; and last index value holder
		int i = 0, j = 0, last = 0;

		for(int k=low; k < high+1; k++) 
		{

			// in case one subarray is depleted, break the loop
			if (i == n1 || j == n2) 
			{
				// but record the last index value
				last = k;
				break;
			}

			// compare each value of left and right subarray
			if ( L[i] <= R[j] )
			{
				arrayValue[k] = L[i];
				i++;
			}
			else 
			{
				arrayValue[k] = R[j];
				j++;
			}
		}

		// copies the remaining values on either the left or the right subarrays
		int kTo = n1-i;
		for(int k=0; k < kTo; k++)
		{
			arrayValue[last + k] = L[i];
			i++;
		}
		kTo = n2-j;
		for(int k=0; k < kTo; k++)
		{
			arrayValue[last + k] = R[j];
			j++;
		}
	}
}

