import matplotlib.pyplot as plt

class SortingAnimation:
    def __init__(self, arr, title):
        self.arr = arr
        self.fig, self.ax = plt.subplots()
        self.ax.set_title(title)
        self.ax.set_xlabel("Index")
        self.ax.set_ylabel("Value")
        self.bars = self.ax.bar(range(len(arr)), arr, color='skyblue')

    def update(self):
        for bar, val in zip(self.bars, self.arr):
            bar.set_height(val)
        plt.pause(0.1)  # Adjust the pause duration as needed

    def show(self):
        plt.show()
