import unittest
import math


def heap_sort(A):
    # make the array a heap tree
    build_heap(A)

    # phase 2: start sorting
    # this will hold the moving max index of the array while sorting
    curr_max_ind = len(A) - 1

    # swap-heapify until it reaches the first index
    while curr_max_ind > 0:
        exchange(A, 0, curr_max_ind)
        curr_max_ind -= 1
        heapify(A, 0, curr_max_ind)
    return A


def build_heap(arr):
    # Down to Up traversing approach
    # Will be pushing values down in the tree structure
    for i in range(len(arr))[::-1]:
        heapify(arr, i)

    return arr

# Issues:
#	1. children - when there is only one child at the moment
#	2. heapify only pushes down the current value at the moment
#		it doesn't push up greater values
# 	OR the answer is I have to assume that all values after the current
# 	(since this is down to up) is already heapified; then the example is not valid


def heapify(A, ind, max_ind=-1):
    # if the max_ind value is not set; use the full length of array
    if max_ind == -1:
        max_ind = len(A) - 1

    # recursively push down the current value
    # until it is greater than its children
    c = get_children_indices(ind)

    # if it is greater than (equal) both its children, stop
    j = -1
    if c[0] > max_ind:
        return A
    elif c[0] <= max_ind:
        if c[1] <= max_ind:
            # if there are two children get the max value from the two
            if max(A[c[0]], A[c[1]]) == A[c[0]]:
                j = c[0]
            else:
                j = c[1]
        else:
            j = c[0]

    # now compare the value using the given index and the largest value of
    # from children
    if A[ind] < A[j]:
        exchange(A, ind, j)
        return heapify(A, j, max_ind)
    else:
        return A


def exchange(A, i, k):
    temp = A[i]
    A[i] = A[k]
    A[k] = temp
    return A


def get_parent_index(i):
    if i == 0:
        return -1

    # index - 1; then divide by two; get the int floor value
    return int(math.floor((i - 1) / 2))


def get_children_indices(i):
    base = (i + 1) * 2
    return (base - 1, base)


class UnitTestClass(unittest.TestCase):

    def test_heap_sort(self):
        self.assertEquals(heap_sort([5, 2, 3, 10, 1, 7]), [1, 2, 3, 5, 7, 10])
        self.assertEquals(
            heap_sort([10, 9, 8, 7, 1, 2, 3, 4, 5]), [1, 2, 3, 4, 5, 7, 8, 9, 10])
        self.assertEquals(
            heap_sort([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

    def test_build_heap(self):
        self.assertEqual(build_heap([1, 2, 3, 4]), [4, 2, 3, 1])
        self.assertEqual(
            build_heap([5, 6, 7, 2, 1, 3, 4]), [7, 6, 5, 2, 1, 3, 4])

    def test_get_parent_index(self):
        self.assertEqual(get_parent_index(0), -1)

        self.assertEqual(get_parent_index(1), 0)
        self.assertEqual(get_parent_index(2), 0)

        self.assertEqual(get_parent_index(3), 1)
        self.assertEqual(get_parent_index(4), 1)

        self.assertEqual(get_parent_index(5), 2)
        self.assertEqual(get_parent_index(6), 2)

        self.assertEqual(get_parent_index(9), 4)
        self.assertEqual(get_parent_index(10), 4)

        self.assertNotEqual(get_parent_index(7), 4)
        self.assertNotEqual(get_parent_index(11), 6)

    def test_get_children_indices(self):
        self.assertEqual(get_children_indices(0), (1, 2))
        self.assertEqual(get_children_indices(1), (3, 4))
        self.assertEqual(get_children_indices(2), (5, 6))
        self.assertEqual(get_children_indices(7), (15, 16))

        self.assertNotEqual(get_children_indices(2), ())
        self.assertNotEqual(get_children_indices(2), (10, 11))
        self.assertNotEqual(get_children_indices(3), (1, 2))

    def test_exchange(self):
        lst = [1, 2, 3, 4, 5]
        self.assertEquals(exchange(lst, 0, 1), [2, 1, 3, 4, 5])
        lst = [1, 2, 3, 4, 5]
        self.assertEquals(exchange(lst, 2, 1), [1, 3, 2, 4, 5])

    def test_heapify(self):
        # all example arrays should be heapified
        # from current_index+1 to max_index
        lst = [1, 5, 2, 4, 3]
        self.assertEqual(heapify(lst, 0), [5, 4, 2, 1, 3])
        lst = [3, 5, 7, 2, 1, 10]
        self.assertEqual(heapify(lst, 0, len(lst) - 2), [7, 5, 3, 2, 1, 10])

if __name__ == "__main__":
    unittest.main()
