#include <stdio.h>
#define MaxNumbers 10
int main() {
	void selectionSort(int[], int, int);
	int num[MaxNumbers];
	printf("Type up to %d numbers followed by 0\n", MaxNumbers);
	int n=0, v;
	scanf("%d", &v);

	while ( v != 0 && n < MaxNumbers ) 
	{
		num[n++] = v;
		scanf("%d", &v);
	}

	if ( v != 0) 
	{
		printf("More than %d numbers entered\n", MaxNumbers);
		printf("First %d used\n", MaxNumbers);
	}

	selectionSort(num, 0, n-1);
	printf("\nThe sorted numbers are\n");
	for (int h=0; h<n; h++) printf("%d ", num[h]);
	printf("\n");
}

void selectionSort(int list[], int lo, int hi) {
	int getSmallest(int[], int, int);
	void swap(int[], int, int);

	// loops from lo to hi values (index)
	for( int h=lo; h<hi; h++) {
		int s = getSmallest(list, h, hi);
		swap(list, h, s);
	}
}

/*
 * This returns the index of the smallest number
 * between the lo to hi index
 */
int getSmallest(int list[], int lo, int hi) {
	int small = lo;
	for (int h=lo+1; h <= hi; h++)
		if (list[h] < list[small]) small = h;
	return small;
}

void swap(int list[], int i, int j) {
	int hold = list[i];
	list[i] = list[j];
	list[j] = hold;
}