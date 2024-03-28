package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingVisualizer extends JPanel {
    private int[] array;
    private int delay;

    public SortingVisualizer(int[] array, int delay) {
        this.array = array.clone();
        this.delay = delay;
    }

    public static void main(String[] args) {
        int[] array = {90, 50, 30, 70, 80, 60, 20, 10, 40};

        JFrame frame = new JFrame("Sorting Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer(array, 100);

        JPanel controlPanel = getControlPanel(visualizer);

        frame.add(visualizer, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static JPanel getControlPanel(SortingVisualizer visualizer) {
        JTextField arrayInputField = new JTextField(20);
        arrayInputField.setText(Arrays.toString(visualizer.getArray()));

        JButton generateButton = getjButton(visualizer, arrayInputField);

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

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            visualizer.setArray(visualizer.getArray()); // Reset to original array
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Array:"));
        controlPanel.add(arrayInputField);
        controlPanel.add(generateButton);
        controlPanel.add(bubbleSortButton);
        controlPanel.add(radixSortButton);
        controlPanel.add(insertionSortButton);
        controlPanel.add(shellSortButton);
        controlPanel.add(resetButton);
        return controlPanel;
    }

    private static JButton getjButton(SortingVisualizer visualizer,
                                      JTextField arrayInputField) {
        JButton generateButton = new JButton("Generate Array");
        generateButton.addActionListener(e -> {
            try {
                String input = arrayInputField.getText();
                String[] values = input.split(",");
                int[] array = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    array[i] = Integer.parseInt(values[i].trim());
                }
                visualizer.setArray(array);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter comma-separated numbers.");
            }
        });
        return generateButton;
    }

    public void setArray(int[] array) {
        this.array = array.clone();
        repaint();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / array.length;
        int maxHeight = getHeight();

        for (int i = 0; i < array.length; i++) {
            int x = i * barWidth;
            int y = maxHeight - array[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, array[i]);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, array[i]);
        }
    }

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

    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
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
