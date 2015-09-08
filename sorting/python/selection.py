import unittest

"""
Given: [5, 2, 1, 3, 10]
For every step in the loop, it checks for the least value and puts it in its place.
"""
def selection_sort(A):
    for i in range(0, len(A) - 1):
        min_val = A[i]
        index = i
        for j in range(i + 1, len(A)):
            if A[j] < min_val:
                min_val = A[j]
                index = j
        A[index] = A[i]
        A[i] = min_val
    return A


class SelectionTest(unittest.TestCase):

    def test_selection_sort(self):
        self.assertEqual(selection_sort([5, 2, 1]), [1, 2, 5])
        self.assertEqual(selection_sort([5, 2, 1, 3, 10]), [1, 2, 3, 5, 10])

if __name__ == "__main__":
    unittest.main()
