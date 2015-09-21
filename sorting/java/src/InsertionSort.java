import java.util.*;
import java.io.File;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		for (int i = 1; i < n; ++i)
		{
			int curr = arr[i]; // 
			int pos = i; // position of curr value 

			while(pos > 0 && curr < arr[pos-1]) {
				arr[pos] = arr[pos-1];
				pos = pos - 1;
			}
			arr[pos] = curr;
		}
	}
	
}