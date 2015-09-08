import unittest
"""
Every j element of A is 1 <= j <= n; where n is the len(A)
and every element is distinct.
This means that for every given set of values the median cannot be 1 or 2n
[1, 2, 3]
[3, 5, 2, 1, 4] - given a four values; it can't be [1, 2, 9, 10] 
but it can be [3, 4, 5, 6, 7, 8]
[1, 2, 3, 4, 5, 6, 7] --- [1, 2, 3, 12, 13, 14] & [4, 5, 6, 7, 8, 9, 10, 11]
So for every n-count list (n is odd),
"""


def median_linear(A, n):

    # array of n/2 + 1
    A2 = [0] * (2 * len(A))
    for i in range(0, len(A)):
        A2[A[i] - 1] = A[i]

    count = 0
    for i in range(0, len(A2)):
        if A2[i] > 0:
            if count == int(len(A) / 2):
                return A2[i]
            count += 1


class MedianLinear(unittest.TestCase):

    def test_median_linear(self):
        self.assertEqual(median_linear([5, 2, 1, 3, 10], 5), 3)
        self.assertEqual(median_linear([10, 6, 12, 2, 8, 9, 14], 7), 9)
        self.assertEqual(median_linear([6, 1, 3], 3), 3)
        self.assertEqual(median_linear([1], 1), 1)

        self.assertNotEqual(median_linear([7, 2, 3, 4, 10], 5), 9)
        self.assertNotEqual(median_linear([10, 6, 12, 2, 8, 9, 14], 7), 2)
        self.assertNotEqual(median_linear([6, 1, 3], 3), 2)
        self.assertNotEqual(median_linear([1], 1), 10)


if __name__ == "__main__":
    unittest.main()
