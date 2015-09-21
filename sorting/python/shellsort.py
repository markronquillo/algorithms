import unittest


def shell_sort(A):
    seq = [4, 2, 1]
    # h = 4
    for k in range(len(seq)):
        h = seq[k]
        for i in range(0, len(A)):
            index = i + h

            if index >= len(A):
                break

            current = A[index]
            while index-h >= 0 and current < A[index - h]:
                A[index] = A[index - h]
                index -= h
            A[index] = current  # index because index-1 defeats current
    return A


class UnitTestClass(unittest.TestCase):

    def test_shell_sort(self):
        self.assertEqual(shell_sort([12, 3, 7, 8, 5, 9, 13, 17, 2, 8, 1]), [
                         1, 2, 3, 5, 7, 8, 8, 9, 12, 13, 17])

if __name__ == "__main__":
    unittest.main()
