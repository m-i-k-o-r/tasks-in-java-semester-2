package ru.vsu.cs.course1;

import java.util.ArrayList;

/**
 * ЗАДАЧА №9 (с *) из файла, который загружен на мудл
 *
 * Найти минимальное кол-во шагов, за которое шахматная фигура конь может из одной
 * заданной клетки шахматного поля попасть в другую клетку шахматного поля, а также
 * последовательность таких шагов (если их несколько, то любую).
 *
 * Требуется решить задачу в 2-х вариантах:
 * 1. С использованием стека / очереди, самостоятельно реализованных на основе
 * связного списка.
 * 2. С использованием реализации стека / очереди, которая уже есть в стандартной
 * библиотеки языка Java
 */
public class MainList {

    /**
     *Это Через Связанные Списки
     */
    public static int[][] main(int[] arr, int[] arrFinal) throws Exception {

        Cell startCell = new Cell(arr);
        Cell finalCell = new Cell(arrFinal);

        SaveCells roadCells =  Calculate.Calcul(startCell, finalCell);

        ArrayList<Cell> list = new ArrayList<>();

        while (roadCells.previousMesh() != null){
            list.add(roadCells.mesh());
            roadCells = roadCells.previousMesh();
        }

        int [][] arrNew = new int[list.size() + 1][2];
        arrNew[0][0] = startCell.col();
        arrNew[0][1] = startCell.row();
        for(int i = 0; i < list.size(); i ++){
            Cell k = list.get(list.size() - i - 1);
            arrNew[i + 1][0] = k.col();
            arrNew[i + 1][1] = k.row();
        }

        return arrNew;
    }
}

