package ru.vsu.cs.course1;

public class SelectionSort {

public static int[] sort(int[] data, int [] toFrom) {
    int size = data.length;
    int from = toFrom[0];
    int to = toFrom[1];
    for (int i = 0; i < size - 1; i++) {
        if(i >= from && i <= to) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if(j >= from && j <= to) {
                    if (data[j] < data[minIndex]) {
                        minIndex = j;
                    }
                }
            }
            // обмер элементов [i] и [minIndex]
            // (можно добавить дополнительную проверку, что minIndex != i)
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
    }
    return data;
}
}
