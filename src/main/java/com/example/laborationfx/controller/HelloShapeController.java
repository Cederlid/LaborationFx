package com.example.laborationfx.controller;

import com.example.laborationfx.ShapeType;
import com.example.laborationfx.ShapesModel;
import com.example.laborationfx.shape.Shape;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class HelloShapeController {

    public Canvas canvas;

    public ChoiceBox<ShapeType> shapeMenu;
    public Slider sizeChoice;
    public CheckBox selectMode;

    private Shape shapeSelected;                   // null means nothing is selected

    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    @FXML
    private ColorPicker colorPicker;

    ShapesModel model = new ShapesModel();

    public void changeSizeOnSelected(double size) {
        if (shapeSelected != null) {
            shapeSelected.setSize(size);
            refreshCanvas();
        }
    }

    public void changeColorOnSelected(Color color) {
        if (shapeSelected != null) {
            shapeSelected.setColor(color);
            refreshCanvas();
        }
    }

    public void initialize() {
        colorPicker.valueProperty().bindBidirectional(model.getColor());
        sizeChoice.valueProperty().bindBidirectional(model.getSize());
        shapeMenu.setItems(shapeTypesList);
        model.getSize().addListener((observableValue, old, newValue) ->
                changeSizeOnSelected(newValue.doubleValue()));
        model.getColor().addListener((observableValue, color, newColor) ->
                changeColorOnSelected(newColor));
    }
}