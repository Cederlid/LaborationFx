package com.example.laborationfx.controller;

import com.example.laborationfx.Circle;
import javafx.scene.paint.Color;

public class ShapeModel {

    public static Circle newCircle(Color color, double size, double x, double y){
        return new Circle(color, size, x, y);
    }

}
