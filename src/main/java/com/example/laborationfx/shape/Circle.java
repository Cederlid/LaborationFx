package com.example.laborationfx.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getColor());
        graphicsContext.fillOval(getX() - getRadius() , getY() - getRadius(), getSize(), getSize());
    }

    public boolean isInside(double x, double y) {
        double distanceX = x - getX();
        double distanceY = y - getY();

        double distanceFromCenter = Math.sqrt(distanceX * distanceX + distanceY * distanceY) ;
        return distanceFromCenter <= getRadius();
    }

    @Override
    public String toSvg() {
        return "<circle " + "cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + getRadius() + "\" " +
                "fill=\"" + toWebColor() + "\"/>";
    }

    public double getRadius() {
        return getSize() / 2;
    }

    public Circle(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }

    @Override
    public String toString() {
        return "'Circle'{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }



}
