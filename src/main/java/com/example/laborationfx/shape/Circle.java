package com.example.laborationfx.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getColor());
        graphicsContext.fillOval(getX() - getRadius(), getY() - getRadius(), getRadius(), getRadius());
    }

    public boolean isInside(double x, double y) {
        double distanceX = x - getX();
        double distanceY = y - getY();

        double distanceFromCenter = distanceX * distanceY + distanceY * distanceX;
        return distanceFromCenter <= getRadius();
    }

    public double getRadius() {
        return getSize() / 2;
    }

    public Circle(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }


}
