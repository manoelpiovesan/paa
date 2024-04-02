package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingVisualizer extends JPanel {

    // Atributo de delay da animação
    private final int delay;
    // Atributo do array a ser ordenado
    private int[] array;

    // Construtor da classe
    public SortingVisualizer(int[] array, int delay) {
        this.array = array.clone();
        this.delay = delay;
    }

    // Método main
    public static void main(String[] args) {
        int[] array =
                {90, 50, 30, 70, 80, 60, 20, 10, 40, 3, 123, 43, 78, 99, 200,
                        132, 100, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                        74, 23, 45, 67, 89, 12, 34, 56, 78, 90, 1, 2, 3, 4, 5,
                        6, 7, 8, 9, 10};

        JFrame frame = new JFrame("Trabalho de PAA - Manoel e Joao Marcello");
        SortingVisualizer visualizer = new SortingVisualizer(array, 100);

        JScrollPane controlPanel = getControlPanel(visualizer);

        frame.add(visualizer, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Método que retorna o painel de controle
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

        // Adicionando os botões ao painel de controle
        JPanel controlPanel = new JPanel(new GridLayout(0,2,5,5));
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
        controlPanel.revalidate();

        JScrollPane scrollPane = new JScrollPane(controlPanel);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    // Método que retorna o botão de injetar array/reiniciar
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

    // Método que desenha os retângulos
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / array.length;
        int maxHeight = getHeight();

        for (int i = 0; i < array.length; i++) {
            int x = i * barWidth;
            int y = maxHeight - array[i];
            g.setColor(Color.RED);
            g.fillRect(x, y, barWidth, array[i]);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, array[i]);
        }
    }

    // Métodos de ordenação
    public void bubbleSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - i - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            swap(j, j + 1);
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

    public void radixSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                int max = getMax(array);
                for (int exp = 1; max / exp > 0; exp *= 10) {
                    countingSort(array, exp);
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void bitonicSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int k = 2; k <= n; k = k * 2) {
                    for (int j = k / 2; j > 0; j = j / 2) {
                        for (int i = 0; i < n; i++) {
                            int l = i ^ j;
                            if (l > i) {
                                if ((i & k) == 0 && array[i] > array[l]) {
                                    swap(i, l);
                                }
                                if ((i & k) != 0 && array[i] < array[l]) {
                                    swap(i, l);
                                }
                            }
                        }
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

    public void radixSortLDS() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                int max = getMax(array);
                for (int exp = 1; max / exp > 0; exp *= 10) {
                    countingSortLDS(array, exp);
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    private void countingSortLDS(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int j : array) {
            count[(j / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, n);
    }

    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int j : array) {
            count[(j / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, n);
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

    public void insertionSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int i = 1; i < n; ++i) {
                    int key = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j = j - 1;
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
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int i = 1; i < n; ++i) {
                    int key = array[i];
                    int j = Math.abs(Arrays.binarySearch(array, 0, i, key) + 1);
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = key;
                    SwingUtilities.invokeLater(this::repaint);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });
        sortingThread.start();
    }

    public void shellSort() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            try {
                int n = array.length;
                for (int gap = n / 2; gap > 0; gap /= 2) {
                    for (int i = gap; i < n; i++) {
                        int temp = array[i];
                        int j;
                        for (j = i; j >= gap && array[j - gap] > temp;
                             j -= gap) {
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
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
