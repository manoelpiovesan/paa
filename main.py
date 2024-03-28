from Algoritmos import Algoritmos
from Animacao import Animacao

default_arr = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
algoritmo = Algoritmos()

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Shell Sort")
for state in algoritmo.shell_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Bubble Sort")
for state in algoritmo.bubble_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Shell Sort")
for state in algoritmo.shell_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Selection Sort")
for state in algoritmo.selection_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Insertion Sort")
for state in algoritmo.insertion_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Heap Sort")
for state in algoritmo.heap_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)


arr = default_arr.copy()
iteracoes = 0
sorting_animation = Animacao(arr, "Radix Sort")
for state in algoritmo.radix_sort(arr):
    iteracoes += 1
    sorting_animation.update(iteration=iteracoes)

sorting_animation.close()

