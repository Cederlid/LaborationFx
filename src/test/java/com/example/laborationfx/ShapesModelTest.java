package com.example.laborationfx;

import com.example.laborationfx.shape.Circle;
import com.example.laborationfx.shape.Square;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapesModelTest {

    ShapesModel model = new ShapesModel();

    Circle circle = new Circle(Color.RED, 12, 12, 15);
    Square square = new Square(Color.RED, 12, 12, 15);

    @Test
    void changeColorTest() {
        model.addShape(circle);
        model.addShape(square);
        circle.setColor(Color.BLACK);
        assertEquals(Color.BLACK, model.getShapes().getFirst().getColor());
    }

    @Test
    void undoFromShapesList() {
        model.addShape(circle);
        model.addShape(square);
        model.undo();
        int size = model.getShapes().size();
        assertEquals(1, size);
        assertEquals(circle, model.getShapes().getFirst());
    }

    @Test
    void isInsideTrue() {
        assertTrue(circle.isInside(10, 10));
    }

    @Test
    void isInsideFalse() {
        assertFalse(circle.isInside(0, 0));
    }

}