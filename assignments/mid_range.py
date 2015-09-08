import unittest


def mid_range(A, n):
    if len(A) < 1:
        return 0

    max = A[0]
    min = A[0]
    for i in range(1, len(A)):
        if A[i] > max:
            max = A[i]
        if A[i] < min:
            min = A[i]
    return (max + min) / 2


class TestMidRange(unittest.TestCase):

    def test_mid_range(self):
        self.assertEqual(mid_range([1, 1, 3, 4, 5], 0), 3)
        self.assertEqual(mid_range([1, 1, 1, 1, 1], 0), 1)
        self.assertEqual(mid_range([10, 10, 1, 1, 1], 0), 5)
        self.assertEqual(mid_range([1, 1, 1, 1, 1], 0), 1)

if __name__ == "__main__":
    unittest.main()
