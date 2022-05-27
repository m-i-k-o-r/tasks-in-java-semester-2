package ru.vsu.cs.course1;

import java.util.ArrayList;

public class MainVstr {

    /**
     *Это Через Встроенные Методы
     */
    public static int[][] main(int[] arr, int[] arrFinal){

        Cell startCell = new Cell(arr);
        Cell finalCell = new Cell(arrFinal);

        SaveCells roadCells =  CalculateVstr.Calcul(startCell, finalCell);

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
