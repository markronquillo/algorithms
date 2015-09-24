import java.util.*;
import java.io.File;
import java.util.Arrays;

public class RadixSort extends SortingAlgorithm {
	private ArrayList<ArrayList> Bucket;
	public RadixSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		// get the maximum value; then get its number of digits
		int maxDigitCount = 5; // this for now

		// initialize the Bucket; an array that contains ArrayList
		Bucket = new ArrayList<ArrayList>();
		for(int i=0; i < 10; i++)
			Bucket.add(new ArrayList());

		for(int i=1; i < maxDigitCount; i++)
		{
			for(int k=0; k < n; k++)
			{
				Bucket.get(getDigitValue(arr[k], i)).add(arr[k]);
			}
			pourBucketsContentToArray();
		}
	}

	/**
	 *	Set the values inside the Bucket to an array 
	 * 	then it empties the bucket after
	 */
	private void pourBucketsContentToArray() 
	{
		int counter = 0;
		// System.out.println(Bucket);
		for(int i=0; i<10; i++)
		{
			for(int k=0; k < Bucket.get(i).size(); k++)
			{
				arr[counter] = (int) Bucket.get(i).get(k);
				counter++;
			}

			// clear each Bucket
			Bucket.get(i).clear();
		}
	}

	/**
	 * Returns the digit in the nth place
	 */
	private int getDigitValue(int num, int place)
	{
		int d = ((int) (num / Math.pow(10, place-1))) % 10;
		return d;
	}
	
}