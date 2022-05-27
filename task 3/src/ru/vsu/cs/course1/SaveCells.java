package ru.vsu.cs.course1;

public class SaveCells {

    private Cell mesh;
    private SaveCells previousMesh;

    public Cell mesh(){
        return mesh;
    }

    public SaveCells previousMesh(){
        return previousMesh;
    }

    public SaveCells (Cell cellNow, SaveCells cellBefore){
        this.mesh = cellNow;
        this.previousMesh = cellBefore;
    }

    public SaveCells (Cell cellNow){
        this.mesh = cellNow;
        this.previousMesh = null;
    }
}
