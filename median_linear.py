import unittest


def median_linear(A, n):
	"""
	Every j element of A is 1 <= j <= n; where n is the len(A)
	and every element is distinct.
	This means that for every given set of values the median cannot be 1 or 2n
	[1, 2, 3]
	[3, 5, 2, 1, 4] - given a four values; it can't be [1, 2, 9, 10] but it can be [3, 4, 5, 6, 7, 8]
	[1, 2, 3, 4, 5, 6, 7] --- [1, 2, 3, 12, 13, 14] & [4, 5, 6, 7, 8, 9, 10, 11]
	So for every n-count list (n is odd), 

	"""
    # array of n/2 + 1
    A2 = []
    A2.append(A[0])
    for i in range(1, len(A)):
        n += 1
    return A2


class MedianLinear(unittest.TestCase):

    def test_median_linear(self):
        self.assertTrue(True)

if __name__ == "__main__":
    unittest.main()
