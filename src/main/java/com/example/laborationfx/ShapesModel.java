package com.example.laborationfx;

import com.example.laborationfx.shape.Shape;
import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.util.*;

import static com.example.laborationfx.ShapeType.CIRCLE;

public class ShapesModel {

    private Deque<Shape> shapes;
    private Shape lastUndoShape = null;        //Needs to remember more

    private ObjectProperty<Color> color;
    private DoubleProperty size;
    private ShapeType selectedShapeType;
    private Shape shapeSelected;                   // null means nothing is selected

    public ShapesModel() {
        shapes = new LinkedList<>();
        shapeSelected = null;
        color = new SimpleObjectProperty<>(Color.RED);
        size = new SimpleDoubleProperty(6.5);
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

    public void changeSize() {
        if (shapeSelected != null)
            shapeSelected.setSize(size.getValue());
    }

    public void changeColorOnSelected() {
        if(shapeSelected != null)
            shapeSelected.setColor(color.getValue());
    }

    public Deque<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(Deque<Shape> shapes) {
        this.shapes = shapes;
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

    public Shape getLastUndoShape() {
        return lastUndoShape;
    }

    public Shape getShapeSelected() {
        return shapeSelected;
    }

    public Property<Color> getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public DoubleProperty getSize() {
        return size;
    }

    public ShapeType getSelectedShapeType(ShapeType circle) {
        return selectedShapeType;
    }

    public void setSelectedShapeType(ShapeType shapeType) {
        this.selectedShapeType = shapeType;
    }


    public void setLastUndoShape(Shape lastUndoShape) {
        this.lastUndoShape = lastUndoShape;
    }

    public ShapeType getSelectedShapeType() {
        return selectedShapeType;
    }

    public void setShapeSelected(Shape shapeSelected) {
        this.shapeSelected = shapeSelected;
    }


}
