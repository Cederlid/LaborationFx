package com.example.laborationfx.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getColor());
        graphicsContext.fillRect(getX(), getY(), getSize(), getSize());
    }

    public boolean isInside(double x, double y) {
        double leftX = getX();
        double rightX = getX() + getSize();
        double topY = getY();
        double bottomY = getY() + getSize();

        return x >= leftX && x <= rightX &&
                y >= topY && y <= bottomY;
    }

    @Override
    public String toSvg() {
        return "<rect x=\"" + getX() + "\" " +
                "y=\"" + getY() + "\" " +
                "width=\"" + getSize() + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"" + toWebColor() + "\"/>";
    }


    @Override
    public String toString() {
        return "'Square'{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }
}

