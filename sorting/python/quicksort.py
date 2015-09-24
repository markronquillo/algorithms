import unittest


def sort(A):
    quick_sort(A, 0, len(A) - 1)
    return A


def quick_sort(A, p, r):
    if p < r:
        q = partition(A, p, r)
        quick_sort(A, p, q - 1)
        quick_sort(A, q + 1, r)


def swap(A, i, j):
    temp = A[i]
    A[i] = A[j]
    A[j] = temp


def partition(A, p, r):
    # choose the last item to be the pivot
    x = A[r]
    # set the value of i to be
    i = p - 1

    for j in range(p, r):
        if A[j] <= x:
            i = i + 1
            swap(A, i, j)

    # finally swap the value of pivot to its proper place
    swap(A, i + 1, r)

    # return the index where the pivot is located
    v = i + 1

    if A[p] == A[r]:
        v = (p + r) / 2

    return v


class UnitTestClass(unittest.TestCase):

    def test_quick_sort(self):
        self.assertEquals(
            sort([1, 1, 1, 1, 1, 1, 1, 1]), [1, 1, 1, 1, 1, 1, 1, 1])
        self.assertEquals(sort([10, 3, 2, 11, 7, 1]), [1, 2, 3, 7, 10, 11])
        self.assertEquals(sort([1, 2, 3, 4, 5, 6, 7]), [1, 2, 3, 4, 5, 6, 7])
        self.assertEquals(sort([13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11]), [
                          2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 19, 21])

    def test_swap(self):
        lst = [1, 2, 3, 4]
        swap(lst, 0, 1)
        self.assertEqual(lst, [2, 1, 3, 4])

        lst = [1, 2, 3, 4]
        swap(lst, 1, 3)
        self.assertEqual(lst, [1, 4, 3, 2])


if __name__ == "__main__":
    unittest.main()
