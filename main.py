from Algoritmos import Algoritmos
from Animacao import Animacao

default_arr = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
algoritmo = Algoritmos()

def shell_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Shell Sort")
    for state in algoritmo.shell_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)

def bubble_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Bubble Sort")
    for state in algoritmo.bubble_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)

def selection_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Selection Sort")
    for state in algoritmo.selection_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)

def insertion_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Insertion Sort")
    for state in algoritmo.insertion_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)

def heap_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Heap Sort")
    for state in algoritmo.heap_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)

def radix_sort():
    arr = default_arr.copy()
    iteracoes = 0
    sorting_animation = Animacao(arr, "Radix Sort")
    for state in algoritmo.radix_sort(arr):
        iteracoes += 1
        sorting_animation.update(iteration=iteracoes)


def main():
    while True:
        print(default_arr)
        print("Escolha o algoritmo de ordenação:")
        print("1 - Bubble Sort")
        print("2 - Shell Sort")
        print("3 - Selection Sort")
        print("4 - Insertion Sort")
        print("5 - Heap Sort")
        print("6 - Radix Sort")
        print("7 - Sair")
        opcao = int(input("Digite a opção desejada: "))
        if opcao == 1:
            bubble_sort()
        elif opcao == 2:
            shell_sort()
        elif opcao == 3:
            selection_sort()
        elif opcao == 4:
            insertion_sort()
        elif opcao == 5:
            heap_sort()
        elif opcao == 6:
            radix_sort()
        elif opcao == 7:
            break
        else:
            print("Opção inválida")

if __name__ == "__main__":
    main()

