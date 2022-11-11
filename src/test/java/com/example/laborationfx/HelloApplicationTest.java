package com.example.laborationfx;

import com.example.laborationfx.shape.Circle;
import com.example.laborationfx.shape.Square;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloApplicationTest {
    ShapesModel model = new ShapesModel();

    Circle circle = new Circle(Color.RED, 12, 12, 15);
    Square square = new Square(Color.RED, 12, 12, 15);

    @Test
    void changeColorTest(){
        model.addShape(circle);
        model.addShape(square);
        model.getShapes().getFirst().setColor(Color.BLACK);
        assertEquals(model.getShapes().getFirst().getColor(),Color.BLACK);
    }

    @Test
    void undoFromShapesList(){
        model.addShape(circle);
        model.addShape(square);
        model.undo();
        int size = model.getShapes().size();
        assertEquals(size,1);
    }
  
}