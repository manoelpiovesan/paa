package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingVisualizer extends JPanel {

    // Atributo de delay da animação
    private final int delay;
    // Atributo do array a ser ordenado
    private int[] array;
    // Atributo de controle de iterações
    private int iterations = 0;

    // Construtor da classe
    public SortingVisualizer(int[] array, int delay) {
        this.array = array.clone();
        this.delay = delay;
    }

    // Método main
    public static void main(String[] args) {
        int[] array = Config.array.clone();

        // instanciando o frame (swing)
        JFrame frame = new JFrame("Trabalho de PAA - Manoel e Joao Marcello");
        // instanciando o visualizador em barras
        SortingVisualizer visualizer = new SortingVisualizer(array, 1);
        // instanciando o painel de controle
        JScrollPane controlPanel = getControlPanel(visualizer);
        // Contador

        // Adicionando os componentes ao frame
        frame.add(visualizer, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Método que retorna o painel de controle com os botões
    private static JScrollPane getControlPanel(SortingVisualizer visualizer) {
        JTextField arrayInputField = new JTextField(20);
        // Injetando array inicial
        arrayInputField.setText(Arrays.toString(visualizer.getArray()));

        JButton generateButton = getjButton(visualizer, arrayInputField);

        // Criando botões dos algoritmos de ordenação
        JButton bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.addActionListener(e -> {
            try {
                visualizer.bubbleSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton radixSortButton = new JButton("Radix Sort");
        radixSortButton.addActionListener(e -> {
            try {
                visualizer.radixSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton insertionSortButton = new JButton("Insertion Sort");
        insertionSortButton.addActionListener(e -> {
            try {
                visualizer.insertionSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton shellSortButton = new JButton("Shell Sort");
        shellSortButton.addActionListener(e -> {
            try {
                visualizer.shellSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton binaryInsertionSortButton =
                new JButton("Binary Insertion Sort");
        binaryInsertionSortButton.addActionListener(e -> {
            try {
                visualizer.binaryInsertionSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton combSortButton = new JButton("Comb Sort");
        combSortButton.addActionListener(e -> {
            try {
                visualizer.combSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton bitonicSortButton = new JButton("Bitonic Sort");
        bitonicSortButton.addActionListener(e -> {
            try {
                visualizer.bitonicSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton radixSortLDSButton = new JButton("Radix Sort LDS");
        radixSortLDSButton.addActionListener(e -> {
            try {
                visualizer.radixSortLDS();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton cocktailShakeSortButton = new JButton("Cocktail Shake Sort");
        cocktailShakeSortButton.addActionListener(e -> {
            try {
                visualizer.cocktailShakeSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton timSortButton = new JButton("Tim Sort");
        timSortButton.addActionListener(e -> {
            try {
                visualizer.timSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton gnomeSortButton = new JButton("Gnome Sort");
        gnomeSortButton.addActionListener(e -> {
            try {
                visualizer.gnomeSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton oddEvenSortButton = new JButton("Odd Even Sort");
        oddEvenSortButton.addActionListener(e -> {
            try {
                visualizer.oddEvenSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton heapSortButton = new JButton("Heap Sort");
        heapSortButton.addActionListener(e -> {
            try {
                visualizer.heapSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        JButton mergeSortButton = new JButton("Merge Sort");
        mergeSortButton.addActionListener(e -> {
            try {
                visualizer.mergeSort();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });



        // Adicionando os botões ao painel de controle
        JPanel controlPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        controlPanel.add(arrayInputField);
        controlPanel.add(generateButton);
        controlPanel.add(bubbleSortButton);
        controlPanel.add(radixSortButton);
        controlPanel.add(insertionSortButton);
        controlPanel.add(shellSortButton);
        controlPanel.add(binaryInsertionSortButton);
        controlPanel.add(combSortButton);
        controlPanel.add(bitonicSortButton);
        controlPanel.add(radixSortLDSButton);
        controlPanel.add(cocktailShakeSortButton);
        controlPanel.add(timSortButton);
        controlPanel.add(gnomeSortButton);
        controlPanel.add(oddEvenSortButton);
        controlPanel.add(heapSortButton);
        controlPanel.add(mergeSortButton);
        controlPanel.revalidate();

        JScrollPane scrollPane = new JScrollPane(controlPanel);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    // Método que retorna o botão de reiniciar
    private static JButton getjButton(SortingVisualizer visualizer,
                                      JTextField arrayInputField) {
        JButton generateButton = new JButton("Reiniciar");
        generateButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        generateButton.addActionListener(e -> {
            try {
                String input = arrayInputField.getText()
                                              .replace("[", "")
                                              .replace("]", "")
                                              .trim();
                String[] values = input.split(",");
                int[] array = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    array[i] = Integer.parseInt(values[i].trim());
                }
                visualizer.setArray(array);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                                              "Deve conter apenas números e virgulas.");
            }
        });
        return generateButton;
    }

    // Getter e Setter
    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
        repaint();
    }

    public void incrementIterations() {
        iterations++;
    }

    public void resetInterations() {
        iterations = 0;
    }

    // Método que desenha os retângulos
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = (int) (getWidth() / (array.length * 0.99));
        int maxHeight = getHeight();

        for (int i = 0; i < array.length; i++) {
            int x = i * barWidth;
            int y = maxHeight - array[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, array[i]);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, barWidth, array[i]);
        }
        g.drawString(iterations + " Interacoes", 20, 20);
    }


    // Métodos de ordenação

    public void mergeSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                mergeSort(array, 0, array.length - 1);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void mergeSort(int[] array, int l, int r) throws InterruptedException {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
            SwingUtilities.invokeLater(this::repaint);
            Thread.sleep(delay);
        }
    }

    private void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, l, L, 0, n1);
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            incrementIterations();
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


    public void bubbleSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            swap(j, j + 1);
                            incrementIterations();
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void heapSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                int n = array.length;
                for (int i = n / 2 - 1; i >= 0; i--) {
                    heapify(array, n, i);
                }
                for (int i = n - 1; i > 0; i--) {
                    swap(0, i);
                    incrementIterations();
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                    heapify(array, i, 0);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            incrementIterations();
            SwingUtilities.invokeLater(this::repaint);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            heapify(array, n, largest);
        }
    }


    public void cocktailShakeSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                boolean swapped = true;
                int start = 0;
                int end = array.length;
                while (swapped) {
                    swapped = false;
                    for (int i = start; i < end - 1; ++i) {
                        if (array[i] > array[i + 1]) {
                            swap(i, i + 1);
                            incrementIterations();
                            swapped = true;
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                    if (!swapped) {
                        break;
                    }
                    swapped = false;
                    end = end - 1;
                    for (int i = end - 1; i >= start; i--) {
                        if (array[i] > array[i + 1]) {
                            swap(i, i + 1);
                            incrementIterations();
                            swapped = true;
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                    start = start + 1;
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void timSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            swap(j, j + 1);
                            incrementIterations();
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void gnomeSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            resetInterations();
            try {
                int index = 0;
                while (index < array.length) {
                    if (index == 0) {
                        index++;
                        incrementIterations();
                    }
                    if (array[index] >= array[index - 1]) {
                        index++;
                        incrementIterations();
                    } else {
                        swap(index, index - 1);
                        incrementIterations();
                        index--;
                    }
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void radixSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int max = getMax(array);
                for (int exp = 1; max / exp > 0; exp *= 10) {
                    // Incrementando iterações dentro do countingSort
                    countingSort(array, exp);
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
                SwingUtilities.invokeLater(this::repaint);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void countingSort(int[] array, int exp) {
        Thread countingSortThread = new Thread(() -> {
            try {
                int n = array.length;
                int[] output = new int[n];
                int[] count = new int[10];
                for (int j : array) {
                    count[(j / exp) % 10]++;
                    incrementIterations();
                }
                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                    incrementIterations();
                }
                for (int i = n - 1; i >= 0; i--) {
                    output[count[(array[i] / exp) % 10] - 1] = array[i];
                    count[(array[i] / exp) % 10]--;
                    incrementIterations();
                }
                Thread.sleep(delay);
                System.arraycopy(output, 0, array, 0, n);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        countingSortThread.start();
    }

    public void bitonicSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                bitonicSort(array, 0, array.length, true);
                SwingUtilities.invokeLater(this::repaint);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            SwingUtilities.invokeLater(this::repaint);
        });
        sortingThread.start();
    }

    private void bitonicSort(int[] array, int low, int count, boolean dir) {
        if (count > 1) {
            int k = count / 2;
            bitonicSort(array, low, k, true);
            bitonicSort(array, low + k, k, false);
            bitonicMerge(array, low, count, dir);
            SwingUtilities.invokeLater(this::repaint);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    private void bitonicMerge(int[] array, int low, int count, boolean dir) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                if (dir == (array[i] > array[i + k])) {
                    swap(i, i + k);
                    incrementIterations();
                    SwingUtilities.invokeLater(this::repaint);

                }
            }
            bitonicMerge(array, low, k, dir);
            bitonicMerge(array, low + k, k, dir);
        }
    }

    public void radixSortLDS() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int max = getMax(array);
                for (int exp = 1; max / exp > 0; exp *= 10) {
                    countingSortLDS(array, exp);
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
                SwingUtilities.invokeLater(this::repaint);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void countingSortLDS(int[] array, int exp) {
        Thread countingSortThread = new Thread(() -> {
            try {
                int n = array.length;
                int[] output = new int[n];
                int[] count = new int[10];
                for (int j : array) {
                    count[(j / exp) % 10]++;
                    incrementIterations();
                }
                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                    incrementIterations();
                }
                for (int i = n - 1; i >= 0; i--) {
                    output[count[(array[i] / exp) % 10] - 1] = array[i];
                    count[(array[i] / exp) % 10]--;
                    incrementIterations();
                }
                Thread.sleep(delay);
                System.arraycopy(output, 0, array, 0, n);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        countingSortThread.start();
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void oddEvenSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                boolean isSorted = false;
                while (!isSorted) {
                    isSorted = true;
                    for (int i = 1; i <= n - 2; i = i + 2) {
                        if (array[i] > array[i + 1]) {
                            swap(i, i + 1);
                            isSorted = false;
                            incrementIterations();
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                    for (int i = 0; i <= n - 2; i = i + 2) {
                        if (array[i] > array[i + 1]) {
                            swap(i, i + 1);
                            isSorted = false;
                            incrementIterations();
                            SwingUtilities.invokeLater(this::repaint);
                            Thread.sleep(delay);
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void insertionSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int i = 1; i < n; ++i) {
                    int key = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j = j - 1;
                        incrementIterations();
                    }
                    array[j + 1] = key;
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void combSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                int gap = n;
                boolean swapped = true;
                while (gap != 1 || swapped) {
                    gap = getNextGap(gap);
                    swapped = false;
                    for (int i = 0; i < n - gap; i++) {
                        if (array[i] > array[i + gap]) {
                            incrementIterations();
                            Thread.sleep(delay);
                            SwingUtilities.invokeLater(this::repaint);
                            swap(i, i + gap);
                            swapped = true;
                        }
                    }
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }

    public void binaryInsertionSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int i = 1; i < n; ++i) {
                    int key = array[i];
                    int j = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = key;
                    SwingUtilities.invokeLater(this::repaint);
                    incrementIterations();
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void shellSort() throws InterruptedException {
        resetInterations();
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int gap = n / 2; gap > 0; gap /= 2) {
                    for (int i = gap; i < n; i++) {
                        int temp = array[i];
                        int j;
                        for (j = i; j >= gap && array[j - gap] > temp;
                             j -= gap) {
                            incrementIterations();
                            array[j] = array[j - gap];
                        }
                        array[j] = temp;
                        SwingUtilities.invokeLater(this::repaint);
                        Thread.sleep(delay);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void swap(int i, int j) {
        Thread swapThread = new Thread(() -> {
            try {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                SwingUtilities.invokeLater(this::repaint);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        swapThread.start();
    }

}
