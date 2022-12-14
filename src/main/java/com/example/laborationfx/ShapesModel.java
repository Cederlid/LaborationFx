package com.example.laborationfx;

import com.example.laborationfx.shape.Shape;
import com.example.laborationfx.shape.ShapeType;
import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.util.*;

import static com.example.laborationfx.shape.ShapeType.CIRCLE;

public class ShapesModel {

    private final Deque<Shape> shapes;
    private Shape lastUndoShape = null;

    private final ObjectProperty<Color> color;
    private final DoubleProperty size;
    private final ShapeType selectedShapeType;

    public ShapesModel() {
        shapes = new LinkedList<>();
        color = new SimpleObjectProperty<>(Color.RED);
        size = new SimpleDoubleProperty(20);
        selectedShapeType = CIRCLE;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);

    }

    public void printShapeList() {
        shapes.forEach(System.out::println);
    }

    public Shape findShapeAt(double x, double y) {
        for (Iterator<Shape> it = shapes.descendingIterator(); it.hasNext(); ) {
            Shape shape = it.next();
            if (shape.isInside(x, y))
                return shape;
        }
        return null;
    }

    public Deque<Shape> getShapes() {
        return shapes;
    }

    public void undo() {
        if (!shapes.isEmpty())
            lastUndoShape = shapes.removeLast();
    }

    public void redo() {
        if (lastUndoShape != null) {
            shapes.addLast(lastUndoShape);
            lastUndoShape = null;
        }
    }

    public Property<Color> getColor() {
        return color;
    }

    public DoubleProperty getSize() {
        return size;
    }

    public ShapeType getSelectedShapeType() {
        return selectedShapeType;
    }


}
