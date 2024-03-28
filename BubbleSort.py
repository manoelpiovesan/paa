import numpy as np
from Animation import SortingAnimation

class SortingAlgorithm:
    def __init__(self, arr):
        self.arr = arr

    def bubble_sort(self):
        n = len(self.arr)
        for i in range(n - 1):
            for j in range(0, n - i - 1):
                if self.arr[j] > self.arr[j + 1]:
                    self.arr[j], self.arr[j + 1] = self.arr[j + 1], self.arr[j]
                    yield self.arr.copy()  # Yield current state of the array

arr = np.random.randint(1, 100, size=20)
print("Unsorted array:", arr)

sorting_animation = SortingAnimation(arr, "Bubble Sort")
sorting_algorithm = SortingAlgorithm(arr)
for state in sorting_algorithm.bubble_sort():
    sorting_animation.update()

sorting_animation.show()
