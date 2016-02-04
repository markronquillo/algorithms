import java.util.*;
import java.io.File;
import java.util.Arrays;

/*
 *	Greedy Algorithm
 *	Optimal Offline Caching using "Farthest-in-Future" Algorithm
 */
public class OptimalOfflineCaching {

	private static char[] cacheContent;
    private static String memoryRequestSequence;

	public static void main( String[] args ) throws Exception {
		Scanner sc = new Scanner(new File("./oocp.txt"));
		int sizeOfCache = sc.nextInt();	
		sc.nextLine();
		// assumed that the sizeOfCache is the length of this cacheContent
		cacheContent = sc.nextLine().toCharArray();
		memoryRequestSequence = sc.nextLine();

		int cacheMisses = 0;

		// We'll process each request one at a time
		// and we'll update the cache and monitor the cache misses
		// along the way
		for ( int i=0; i < memoryRequestSequence.length(); i++ ) {
			char currentRequest = memoryRequestSequence.charAt(i);
			if ( ! isInCache(currentRequest) ) {
				// if the current request value is not in the cache
				// we need to fetch in it memory then store it in the cache.
				// decide what value (index in array) in cacheContent to evict using FF
				int index = getCacheValueToEvict(i);
	
				// update the cache
				cacheContent[index] = currentRequest;

				// System.out.println(Arrays.toString(cacheContent));
				// System.out.println(i);
				// System.out.println(currentRequest);

				// count the cacheMisses
				cacheMisses++;
			}
		}

		System.out.println("Minimum number of cache miss: " + cacheMisses);
	}

	/*
	 *	Given the current request position (index)
	 * 	return the index in cacheContent array of the 
	 *	cache value to evict.
	 */
	private static int getCacheValueToEvict(int requestIndex) {
		// holds the current maximum 
		// both index & count
		int evictCount=0;
		int evictIndex=0;

		for (int k=0; k < cacheContent.length; k++) {
			char currentCacheValue = cacheContent[k];
			int count=0;

			// We will now count how many steps away the first instance of
			// the current cache value in the remaining request sequence  
			// we'll just concern ourselves with the one that has the max steps (farthest).
			for (int i=requestIndex+1; i < memoryRequestSequence.length(); i++) {
				count++;
				if (memoryRequestSequence.charAt(i) == currentCacheValue) {
					// stop the count after finding the first instance
					break;
				}
			}

			// get only the index that beats the current evictCount
			if (count > evictCount) {
				evictIndex = k;
				evictCount = count;
			}
		}

		return evictIndex;
	}

	/*
	 *	Returns true if the request value is in the current cacheContent
	 *	else false
	 */
	private static Boolean isInCache(char requestValue) {
		for (int i=0; i < cacheContent.length; i++) 
		{
			if (cacheContent[i] == requestValue) return true;
		}
		return false;
	}
}