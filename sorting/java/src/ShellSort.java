import java.util.*;
import java.io.File;

public class ShellSort extends SortingAlgorithm {

	// default value of increment sequence from the shellsort paper
	int[] sequence = {1391376, 463792, 198768, 86961, 33936, 13776, 4592, 1968, 861, 336, 112, 48, 21, 7, 3, 1};

	public ShellSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{

		for(int k=0; k < this.sequence.length; k++) 
		{
			int h = this.sequence[k];

			for(int i=0; i < n; i++)
			{
				int index = i + h;
				
				// check if the current index is already outside the array
				// break the current loop if it is
				// this will also ignore increment sequence values 
				// that is outside the array bounds
				if (index >= n)	break;

				int current = arr[index];
				while (index-h >= 0 && current < arr[index -h])
				{
					arr[index] = arr[index - h];
					index -= h;
				}
				arr[index] = current;
			}
		}
	}

	public void setSequence(int[] seq)
	{
		this.sequence = seq;
	}
	
}