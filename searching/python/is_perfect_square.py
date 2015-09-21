import unittest
import math


def is_perfect_square(A, v, l, h):

    if l >= h:
        return -1

    mid = int(math.ceil((h + l) / 2))
    if A[mid] > v:
        return is_perfect_square(A, v, l, mid)
    elif A[mid] < v:
        return is_perfect_square(A, v, mid + 1, h)
    else:
        return mid


class Test(unittest.TestCase):

    def test_is_perfect_square(self):
        self.assertEqual(is_perfect_square([1, 2, 3, 4, 10], 10, 0, 5), 4)
        self.assertEqual(is_perfect_square(range(1, 6), 0, 0, 5), -1)
        self.assertEqual(is_perfect_square([1, 2, 3, 4, 5], 1, 0, 5), 0)
        self.assertEqual(is_perfect_square([1, 2, 3, 4, 5], 2, 0, 5), 1)
        self.assertEqual(is_perfect_square([1], 2, 0, 1), -1)
        self.assertEqual(is_perfect_square([1], 1, 0, 1), 0)

    def test_is_perfect_square_not_equals(self):
        self.assertNotEqual(is_perfect_square([1, 2, 3, 4, 5], 2, 0, 5), -1)
        self.assertNotEqual(
            is_perfect_square([5, 10, 33, 500, 5252, 10000, 100001], 33, 0, 7), -1)
        self.assertNotEqual(is_perfect_square([1], 2, 0, 1), 1)
        self.assertNotEqual(is_perfect_square([1, 2], 2, 0, 2), 2)
        self.assertNotEqual(is_perfect_square([1, 2], 3, 0, 2), 2)

if __name__ == "__main__":
    unittest.main()
