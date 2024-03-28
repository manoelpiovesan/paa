import matplotlib.pyplot as plt

class Animacao:
    def __init__(self, arr, title):
        self.arr = arr
        self.fig, self.ax = plt.subplots()
        self.ax.set_title(title)
        self.fig.get_axes()[0].set_axis_off()
        self.bars = self.ax.bar(range(len(arr)), arr, color='red')

    def update(self, iteration):
        for bar, val in zip(self.bars, self.arr):
            bar.set_height(val)
        plt.suptitle(f"Iteração: {iteration}")
        plt.pause(0.1)  

    def show(self):
        plt.show()
    
    
