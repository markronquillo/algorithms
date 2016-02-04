#include <stdio.h>

#define MaxNumbers 8
int main() {
	void insertionSort(int[], int, int);
	int num[8] = {55, 10, 1, 3, 7, 88, 100, 102};

	insertionSort(num, 0, MaxNumbers-1);
	printf("\nThe sorted numbers are\n");
	for (int h=0; h<MaxNumbers; h++) printf("%d ", num[h]);
	printf("\n");
}

void insertionSort(int list[], int lo, int hi) {

	// loop from lo+1 to hi
	for( int i=lo+1; i<=hi; i++) 
	{
		int ind=i-1;
		int hold=list[i];

		// check previous numbers
		while ( ind!=0 && list[i] < list[ind] )
		{
			list[i] = list[ind];
			ind--;
		}
		list[ind] = hold;
	}
}
