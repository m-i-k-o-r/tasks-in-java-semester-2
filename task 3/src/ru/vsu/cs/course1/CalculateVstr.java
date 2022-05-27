package ru.vsu.cs.course1;

import java.util.LinkedList;
import java.util.Queue;

public class CalculateVstr {
    public static SaveCells Calcul(Cell cellBeginning, Cell CellFinal){
        Queue<SaveCells> listQueue = new LinkedList<>();
        listQueue.add(new SaveCells(cellBeginning));
        SaveCells finalCells = cycle(listQueue, CellFinal);
        return finalCells;
    }

    public static SaveCells cycle(Queue<SaveCells> listQueueOld, Cell CellFinal){

        Queue<SaveCells> listQueueNew = new LinkedList<>();

        int[] addCol = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] addRow = {2, -2, 2, -2, 1, -1, 1, -1};

        while (listQueueOld.size() != 0) {
            SaveCells cellVariable = listQueueOld.remove();
            for (int i = 0; i < addCol.length; i++) {
                Cell cellIntermediate = new Cell((cellVariable.mesh()).col() + addCol[i], (cellVariable.mesh()).row() + addRow[i]);
                if ((cellVariable.mesh()).col() != cellIntermediate.col() || (cellVariable.mesh()).row() != cellIntermediate.row()) {
                    SaveCells temporaryVariable = new SaveCells(cellIntermediate, cellVariable);
                    listQueueNew.add(temporaryVariable);
                }
            }
            if ((cellVariable.mesh()).col() == CellFinal.col() && (cellVariable.mesh()).row() == CellFinal.row()) {
                return cellVariable;
            }
        }
        SaveCells returnVariable = cycle(listQueueNew, CellFinal);

        return returnVariable;
    }
}
