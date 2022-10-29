package com.example.laborationfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color color, double size, double x, double y) {
        super(color, size, x, y);
    }

    public Square(Shape shape){
        super(shape);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }

    @Override
    public boolean isInside(double x, double y) {
        return false;
    }


}
