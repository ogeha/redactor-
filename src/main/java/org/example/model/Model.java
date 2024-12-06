package org.example.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO: 25.10.2024 Сделать singleton класс
public class Model extends Observable {
    private MyShape currentShape;
    private List<MyShape> shapeList = new ArrayList<>();

    public List<MyShape> getShapeList() {
        return shapeList;
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void addCurrentShape(MyShape sampleShape){
        shapeList.add(sampleShape);
    }

    public void createCurrentShape (MyShape shape){
        currentShape = shape;
        shapeList.add(shape);
    }

    public void changeShape(Point2D x, Point2D y) {

        currentShape.setFrame(x, y);
        update();
    }

    public void draw(Graphics2D g) {
        for (MyShape shape : shapeList){
            shape.draw(g);
        }
    }

    public void update() {
        this.setChanged();
        this.notifyObservers();
    }


    public MyShape getLastShape() {
        int size = shapeList.size();
        return shapeList.isEmpty() ? null : shapeList.get(size-1);
    }

    public void removeLastShape() {
        int size = shapeList.size();
        if (size == 0){
            return;
        }
        else{
            shapeList.remove(size-1);
        }
    }
}
