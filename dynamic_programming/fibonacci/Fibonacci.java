import java.util.*;
import java.io.File;
import java.util.Arrays;

/*
 * Mathematical Specification
 * if n<3 then return 1
 * fib(n-1) + fib(n-2)
 */

public class Fibonacci {
	static final int MAXNUMBER=50;	
	private static long[] TopDownCache = new long[MAXNUMBER+1];
	private static long[] BottomUpCache = new long[MAXNUMBER+1];

	public static void main( String[] args ) throws Exception
	{

		// Simple Recursion
		// long val = SimpleRecursion(MAXNUMBER);
		// System.out.println(val);

		// Top Down
		long tdVal = TopDown(MAXNUMBER);
		System.out.println(tdVal);

		// BottomUp Main
		long btVal = BottomUpMain(MAXNUMBER);
		System.out.println(btVal);
	}

	private static long SimpleRecursion(int n) {
		if ( n < 3 ) return 1;
		return SimpleRecursion(n-1) + SimpleRecursion(n-2);
	}

	private static long TopDown(int n) {
		if ( n < 3 ) return 1;
		if ( TopDownCache[n] != 0) return TopDownCache[n];
		TopDownCache[n] = TopDown(n-1) + TopDown(n-2);
		return TopDownCache[n];
	}

	private static long BottomUpMain(int n) {
		// Setup 
		for(int i=1; i<=n; i++) {
			BottomUpCache[i] = BottomUp(i);
		}
		return BottomUpCache[n];
	}

	private static long BottomUp(int n) {
		if ( n < 3 ) return 1;
		return BottomUpCache[n-1] + BottomUpCache[n-2];
	}
}