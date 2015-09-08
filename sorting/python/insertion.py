import unittest


def insertion_sort(A):
    for i in range(1, len(A)):
        index = i
        current = A[i]
        while index > 0 and current < A[index - 1]:
            A[index] = A[index - 1]
            index -= 1
        A[index] = current  # index because index-1 defeats current
    return A


class InsertionSortingTest(unittest.TestCase):

    def test_insertion_test(self):
        self.assertEqual(insertion_sort([9, 2, 4, 1]), [1, 2, 4, 9])
        self.assertEqual(
            insertion_sort([-5, 33, 8, -24, 9, 10]), [-24, -5, 8, 9, 10, 33])
        self.assertEqual(
            insertion_sort([10, 40, 22, 41, 0]), [0, 10, 22, 40, 41])
        self.assertNotEqual(
            insertion_sort([10, 40, 22, 41, 0]), [10, 22, 40, 41])

if __name__ == "__main__":
    unittest.main()
