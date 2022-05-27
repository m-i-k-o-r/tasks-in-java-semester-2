package ru.vsu.cs.course1;

public class Calculate {
    public static SaveCells Calcul(Cell cellBeginning, Cell CellFinal) throws Exception {
        SimpleLinkedListQueue<SaveCells> listQueue = new SimpleLinkedListQueue<>();
        listQueue.add(new SaveCells(cellBeginning));
        SaveCells finalCells = cycle(listQueue, CellFinal);
        return finalCells;
    }

    public static SaveCells cycle(SimpleLinkedListQueue<SaveCells> listQueueOld, Cell CellFinal) throws Exception {

        SimpleLinkedListQueue<SaveCells> listQueueNew = new SimpleLinkedListQueue<>();

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

