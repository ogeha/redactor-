package org.example.model.shape.factory;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public enum ShapeType {
    RECTANGLE{
        @Override
        public RectangularShape createShape() {
            return new Rectangle2D.Double();
        }
    },
    ELLIPSE{
        @Override
        public RectangularShape createShape() {
            return new Ellipse2D.Double();
        }
    },
    LINE{
        @Override
        public RectangularShape createShape() {
            return new Rectangle2D.Double();
        }
    };

    public abstract RectangularShape createShape();


}
