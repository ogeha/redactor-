package org.example.controller.state;

import org.example.controller.action.AppAction;
import org.example.view.menu.CommandActionListener;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class UndoMachine {
    private UndoRedoState undoRedoState;

    private CommandActionListener undoActionListener;

    private CommandActionListener redoActionListener;

    public UndoMachine() {
        LinkedList<AppAction> undoList = new LinkedList<>();
        LinkedList<AppAction> redoList = new LinkedList<>();
        undoRedoState = new StateDisableUndoDisableRedo(undoList, redoList);
    }

    public void executeRedo() {
        undoRedoState = undoRedoState.redo();
    }

    public void executeUndo() {
        undoRedoState = undoRedoState.undo();
    }

    public boolean isEnableUndo() {
        return !undoRedoState.getUndoActivityList().isEmpty();
    }


    public boolean isEnableRedo() {
        return !undoRedoState.getRedoActivityList().isEmpty();
    }
    public void updateButtons(){
        undoActionListener.setEnabled(isEnableUndo());
        redoActionListener.setEnabled(isEnableRedo());
    }

    public void add(AppAction action) {
        undoRedoState.clearHistory();
        undoRedoState.addAction(action);

        undoRedoState = new StateEnableUndoDisableRedo(undoRedoState.getUndoActivityList(), undoRedoState.getRedoActivityList());
    }


}
