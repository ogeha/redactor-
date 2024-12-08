package org.example.model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.RectangularShape;

public class Adaptor {
    public static Line2D adaptor(RectangularShape shape){
        double x1 = shape.getX();
        double x2 = shape.getX() + shape.getWidth();
        double y1 = shape.getY();
        double y2 = shape.getY() + shape.getHeight();
        return new Line2D.Double(x1,y1,x2,y2);
    }
}
