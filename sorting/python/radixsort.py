import unittest


def radix_sort(A):
    # create an array with
    Bucket = []
    # create ten arrays inside Bucket
    for i in range(10):
        Bucket.append([])

    for i in range(1, 5):
        for k in range(len(A)):
            Bucket[get_digit_value(A[k], i)].append(A[k])
        # sort based on Bucket content
        pour_bucket_content_to_array(Bucket, A)
    return A


def pour_bucket_content_to_array(Bucket, A):
    counter = 0
    for i in range(len(Bucket)):
        for k in range(len(Bucket[i])):
            A[counter] = Bucket[i][k]
            counter += 1
        # empty Bucket i
        del Bucket[i][:]


def get_digit_value(num, place):
    return (num / (10 ** (place - 1)) % 10)


class UnitTestClass(unittest.TestCase):

    def test_radix_sort(self):
		self.assertEquals(radix_sort([5231, 4231, 414, 1004]), [414, 1004, 4231, 5231])
		self.assertEquals(radix_sort([6140, 2010, 3000, 5]), [5, 2010, 3000, 6140])
		self.assertEquals(radix_sort([1234, 1, 2, 3]), [1, 2, 3, 1234])

    def test_get_digit_value(self):
        self.assertEquals(get_digit_value(54321, 3), 3)

if __name__ == "__main__":
    unittest.main()
