import numpy as np
from Animacao import Animacao

class Algoritmos:
    @staticmethod
    def bubble_sort(arr):
        n = len(arr)
        for i in range(n):
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    yield arr.copy()
    
        
    @staticmethod          
    def shell_sort( arr):
        n = len(arr)
        gap = n // 2
        while gap > 0:
            for i in range(gap, n):
                temp = arr[i]
                j = i
                while j >= gap and arr[j - gap] > temp:
                    arr[j] = arr[j - gap]
                    j -= gap
                arr[j] = temp
            gap //= 2
            yield arr.copy()
            
    @staticmethod      
    def selection_sort( arr):
        n = len(arr)
        for i in range(n):
            min_idx = i
            for j in range(i + 1, n):
                if arr[min_idx] > arr[j]:
                    min_idx = j
            arr[i], arr[min_idx] = arr[min_idx], arr[i]
            yield arr.copy()
        
    @staticmethod 
    def insertion_sort( arr):
        n = len(arr)
        for i in range(1, n):
            key = arr[i]
            j = i - 1
            while j >= 0 and key < arr[j]:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
            yield arr.copy()
    
    @staticmethod      
    def quick_sort(self, arr):
        if len(arr) <= 1:
            return arr
        else:
            pivot = arr[0]
            less = [x for x in arr[1:] if x <= pivot]
            greater = [x for x in arr[1:] if x > pivot]
            return self.quick_sort(less) + [pivot] + self.quick_sort(greater)
    
    @staticmethod      
    def merge_sort(self, arr):
        if len(arr) <= 1:
            return arr
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        left = self.merge_sort(left)
        right = self.merge_sort(right)
        return self.merge(left, right)
          
    def merge( left, right):
        result = []
        i = j = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1
        result += left[i:]
        result += right[j:]
        return result
         
    def heap_sort(self, arr):
        n = len(arr)
        for i in range(n // 2 - 1, -1, -1):
            self.heapify(arr, n, i)
        for i in range(n - 1, 0, -1):
            arr[i], arr[0] = arr[0], arr[i]
            self.heapify(arr, i, 0)
            yield arr.copy()
            
        
    def heapify(self, arr, n, i):
        largest = i
        l = 2 * i + 1
        r = 2 * i + 2
        if l < n and arr[i] < arr[l]:
            largest = l
        if r < n and arr[largest] < arr[r]:
            largest = r
        if largest != i:
            arr[i], arr[largest] = arr[largest], arr[i]
            self.heapify(arr, n, largest)
            
    @staticmethod      
    def counting_sort( arr):
        n = len(arr)
        output = [0] * n
        count = [0] * 10
        for i in range(0, n):
            count[arr[i]] += 1
        for i in range(1, 10):
            count[i] += count[i - 1]
        i = n - 1
        while i >= 0:
            output[count[arr[i]] - 1] = arr[i]
            count[arr[i]] -= 1
            i -= 1
        for i in range(0, n):
            arr[i] = output[i]
            yield arr.copy()
            
    def radix_sort(self, arr):
        max1 = max(arr)
        exp = 1
        while max1 / exp > 0:
            self.counting_sort_for_radix(exp, arr)
            exp *= 10
            yield arr.copy()
            
              
    def counting_sort_for_radix(self, exp, arr):
        n = len(arr)
        output = [0] * n
        count = [0] * 10
        for i in range(0, n):
            index = int(arr[i] / exp)
            count[index % 10] += 1
        for i in range(1, 10):
            count[i] += count[i - 1]
        i = n - 1
        while i >= 0:
            index = int(arr[i] / exp)
            output[count[index % 10] - 1] = arr[i]
            count[index % 10] -= 1
            i -= 1
        for i in range(0, n):
            arr[i] = output[i]