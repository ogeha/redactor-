package org.example.controller.action;

import org.example.controller.ShapeCreator;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;

public class ActionDraw implements AppAction {
    private MyShape sampleShape;

    private ShapeCreator shapeCreator;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private Model model;
    private MyShape drawableShape;

    public ActionDraw(Model model) {
        this.model = model;
        shapeCreator = ShapeCreator.getInstance();


    }

    public void stretchShape(Point2D point){
        secondPoint = point;
        sampleShape.setFrame(firstPoint, secondPoint);
        model.update();
    }
    public void createShape(Point2D point){
        firstPoint = point;
        sampleShape = shapeCreator.createShape();
        model.createCurrentShape(sampleShape.clone());
        model.update();
    }

    @Override
    public void mousePressed(Point2D point) {
        secondPoint = point;
        sampleShape = shapeCreator.createShape();
        drawableShape = sampleShape;
        model.addCurrentShape(sampleShape);
        model.update();
    }

    @Override
    public void mouseDragged(Point2D point) {
        firstPoint = point;
        sampleShape.setFrame(firstPoint, secondPoint);
        drawableShape.setFrame(firstPoint, secondPoint);
        model.update();
    }

    @Override
    public void execute() {
        model.addCurrentShape(drawableShape);
        model.update();
    }

    @Override
    public void unexecute() {
        drawableShape = model.getLastShape();
        model.removeLastShape();
        model.update();
    }

    @Override
    public AppAction cloneAction() {
        ActionDraw actionDraw = new ActionDraw(model);
        actionDraw.sampleShape = sampleShape.clone();
        actionDraw.drawableShape = drawableShape;
        return actionDraw;
    }
}
