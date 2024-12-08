package org.example.model.shape.fill;

import org.example.model.shape.factory.ShapeType;

import java.awt.*;
import java.awt.geom.RectangularShape;
import org.example.model.Adaptor;

public class NoFill implements FillBehavior {
    private Color color;
    private RectangularShape shape;
    private boolean line;

    public NoFill() {
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        if (!this.line) {
            Paint paint = g.getPaint();
            g.setPaint(color);
            g.draw(shape);
            g.setPaint(paint);
        }
        if (this.line){
            Paint paint = g.getPaint();
            g.setPaint(color);
            Adaptor adaptor = new Adaptor();
            g.draw(Adaptor.adaptor(shape));
            g.setPaint(paint);
        }
    }

    @Override
    public void setShape(RectangularShape s) {
        shape = s;
    }

    @Override
    public void setLine(boolean line) {
        this.line = line;
    }

    @Override
    public FillBehavior clone() {
        NoFill nofill = new NoFill();
        nofill.setColor(color);
        nofill.shape = (RectangularShape) shape.clone();
        return nofill;
    }
}
