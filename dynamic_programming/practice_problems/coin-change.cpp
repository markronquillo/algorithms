#include <iostream>


using namespace std;


int *memo; // topdown
int *memoBU; // bottom up

int minVal(int a, int b, int c) {
    if (a < b) return (a < c) ? a : c;
    else return (b < c) ? b : c;
}

int recurTD(const int& value) {


    if (memo[value] > 0) return memo[value];

    if (value < 1) return 0;
    if (value < 10) return value;
    if (value < 25) {
        int minValue = min(recurTD(value-1)+1, recurTD(value-10)+1);
        memo[value] = minValue;
    }

    int minValue = minVal(recurTD(value-1)+1, recurTD(value-10)+1, recurTD(value-25)+1);
    memo[value] = minValue;
    return minValue;
}

int bottomUP(const int& value) {

    for (int i=0; i < 10; i++) memoBU[i] = i;
    memoBU[10] = 1;

    for (int i=11; i < 25; i++) {
        memoBU[i] = min(memoBU[i-1]+1, memoBU[i-10]+1);
    }
    memoBU[25] = 1;

    for (int i=26; i <= value; i++) {
        memoBU[i] = minVal(memoBU[i-1]+1, memoBU[i-10]+1, memoBU[i-25]+1);
    }

    return memoBU[value];
}


int main() {
    int value = 110;
    memo = new int[value];
    memoBU = new int[value+50]; // index zero doesn't hold anything
    cout << recurTD(value) << endl;
    cout << bottomUP(value) << endl;
    return 0;
}
