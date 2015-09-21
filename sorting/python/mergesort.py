import unittest
import math


def merge_sort(A, low, high):
    if low < high:
        mid = int(math.floor((high + low) / 2))
        merge_sort(A, low, mid)
        merge_sort(A, mid + 1, high)
        merge(A, low, mid, high)
    return A


def merge(A, low, mid, high):
    n1 = mid - low + 1
    n2 = high - mid

    # create two containers for the sub-arrays
    L = []
    R = []

    # fill up the left sub-array; ranging from low to mid
    for i in range(0, n1):
        L.append(A[low + i])

    # fill up the right sub-array; ranging from mid+1 to high
    for i in range(0, n2):
        R.append(A[mid + i + 1])

    # this holds the value for the last index where the merging stops
    last = 0
    # left and right counter value
    i, j = 0, 0

    # compare each item left and right
    for k in range(low, high + 1):
        # break the loop if either left/right array is depleted
        if i == len(L) or j == len(R):
            last = k
            break

        if L[i] <= R[j]:
            A[k] = L[i]
            i = i + 1
        else:
            A[k] = R[j]
            j = j + 1

    # add the remaining items in the left sub-array to the main array
    for k in range(len(L) - i):
        A[last + k] = L[i]
        i = i + 1

    # add the remaining items in the right sub-array to the main array
    for k in range(len(R) - j):
        A[last + k] = R[j]
        j = j + 1


class MergeSortTest(unittest.TestCase):

    def test_merge_sort(self):
        self.assertEqual(
            merge_sort([9, 1, 7, 3, 10, 2, 4, 5], 0, 7), [1, 2, 3, 4, 5, 7, 9, 10])

        self.assertEqual(
            merge_sort([1, 2, 3, 4], 0, 3), [1, 2, 3, 4])

        self.assertEqual(
            merge_sort([9, 1, 3, 7, 10, 2, 4, 5], 0, 7), [1, 2, 3, 4, 5, 7, 9, 10])

        self.assertEqual(
            merge_sort([6, 10, 33], 0, 2), [6, 10, 33])

        self.assertEqual(
            merge_sort([10, 1, 1, 1, 3], 0, 4), [1, 1, 1, 3, 10])

        self.assertEqual(
            merge_sort([99, 99, 1, 99, 3], 0, 4), [1, 3, 99, 99, 99])

        self.assertEqual(
            merge_sort([10, 9, 8, 7, 6, 5], 0, 5), [5, 6, 7, 8, 9, 10])

        self.assertEqual(
            merge_sort([1, 5, 3, 10, 2, 15, 7, 9], 0, 7), [1, 2, 3, 5, 7, 9, 10, 15])

        self.assertEqual(merge_sort([92, 215, 308, 360, 388, 543, 665, 689, 747, 891, 946, 543, 1049, 1057, 1060, 1165, 
        				1251, 1356, 1684, 1805, 1870, 1947, 2030, 2099, 2506, 2637, 2658, 2737, 2965, 3042, 3111, 3292, 3326, 
        				2965, 3402, 3428, 3474, 3541, 3600, 3633, 3912, 3978, 4017, 4027, 4053, 4307, 4355, 4469, 1060,
                        4506, 4518, 4355, 4647, 4712, 4761, 4808, 4900, 4307, 4925, 5059, 4307, 5180, 5303, 747, 5357, 5399, 
                        5544, 5697, 4355, 5715, 6452, 6560, 4017, 6691, 6769, 6863, 6884, 7156, 7200, 7321, 747, 7451, 7585, 
                        7595, 7605, 7707, 7843, 7585, 7854, 7321, 747, 8017, 8091, 8198, 8320, 8557, 543, 9073, 7585, 9569], 0, 99),
                         [92, 215, 308, 360, 388, 543, 543, 543, 665, 689, 747, 747, 747, 747, 891, 946, 1049, 1057, 1060, 1060, 1165, 1251, 1356, 1684, 1805, 1870, 1947, 2030, 2099, 2506, 2637, 2658, 2737, 2965, 2965, 3042, 3111, 3292, 3326, 3402, 3428, 3474, 3541, 3600, 3633, 3912, 3978, 4017, 4017, 4027, 4053,
                             4307, 4307, 4307, 4355, 4355, 4355, 4469, 4506, 4518, 4647, 4712, 4761, 4808, 4900, 4925, 5059, 5180, 5303, 5357, 5399, 5544, 5697, 5715, 6452, 6560, 6691, 6769, 6863, 6884, 7156, 7200, 7321, 7321, 7451, 7585, 7585, 7585, 7595, 7605, 7707, 7843, 7854, 8017, 8091, 8198, 8320, 8557, 9073, 9569]
                         )
        self.assertNotEqual(
            merge_sort([10, 10, 1], 0, 2), [10, 10, 1])

if __name__ == "__main__":
    unittest.main()
