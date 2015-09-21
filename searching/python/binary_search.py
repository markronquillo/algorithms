import unittest
import math


def binary_search(A, v, l, h):

    if l >= h:
        return -1

    mid = int(math.ceil((h + l) / 2))
    if A[mid] > v:
        return binary_search(A, v, l, mid)
    elif A[mid] < v:
        return binary_search(A, v, mid+1, h)
    else:
        return mid


class BinarySearchTest(unittest.TestCase):

    def test_binary_search(self):
        self.assertEqual(binary_search([1, 2, 3, 4, 10], 10, 0, 5), 4)
        self.assertEqual(binary_search([1, 2, 3, 4, 5], 0, 0, 5), -1)
        self.assertEqual(binary_search([1, 2, 3, 4, 5], 1, 0, 5), 0)
        self.assertEqual(binary_search([1, 2, 3, 4, 5], 2, 0, 5), 1)
        self.assertEqual(binary_search([1], 2, 0, 1), -1)
        self.assertEqual(binary_search([1], 1, 0, 1), 0)

    def test_binary_search_not_equals(self):
        self.assertNotEqual(binary_search([1, 2, 3, 4, 5], 2, 0, 5), -1)
        self.assertNotEqual(
            binary_search([5, 10, 33, 500, 5252, 10000, 100001], 33, 0, 7), -1)
        self.assertNotEqual(binary_search([1], 2, 0, 1), 1)
        self.assertNotEqual(binary_search([1, 2], 2, 0, 2), 2)
        self.assertNotEqual(binary_search([1, 2], 3, 0, 2), 2)

if __name__ == "__main__":
    unittest.main()
