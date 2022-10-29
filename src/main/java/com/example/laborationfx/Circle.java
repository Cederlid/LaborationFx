package com.example.laborationfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    private double radius;

    public Circle(Color color, double radius, double x, double y) {
        super(color, radius, x, y);
        this.radius = radius;
    }

    public Circle(Shape shape) {
        super(shape);
        this.radius = ((Circle) shape).getRadius();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean isInside(double x, double y) {
        double distanceX = x - getX();
        double distanceY = y - getY();

        double distanceFromCenter = distanceX * distanceY + distanceY *distanceX;
        return distanceFromCenter < radius * radius;
    }


}
