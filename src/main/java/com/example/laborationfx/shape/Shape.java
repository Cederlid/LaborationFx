package com.example.laborationfx.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public abstract class Shape {

    protected Color color;
    protected double x;
    protected double y;
    protected double size;

    public Shape(Color color, double x, double y, double size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Shape(Shape shape) {
        color = shape.color;
        x = shape.x;
        y = shape.y;
        size = shape.size;
    }

    public static Shape createShape(ShapeType type, Color color, double x, double y, double size) {
        return switch (type) {
            case CIRCLE -> new Circle(color, x, y, size);
            case SQUARE -> new Square(color, x, y, size);

        };
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract boolean isInside(double x, double y);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


}
