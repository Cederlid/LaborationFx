package com.example.laborationfx.controller;

import com.example.laborationfx.ShapeType;
import com.example.laborationfx.ShapesModel;
import com.example.laborationfx.shape.Shape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class HelloShapeController {

    public Canvas canvas;

    public ChoiceBox<ShapeType> shapeMenu;
    public Slider sizeChoice;
    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    @FXML
    private ColorPicker colorPicker;

    ShapesModel model = new ShapesModel();


    public void initialize() {
        colorPicker.valueProperty().bindBidirectional(model.getColor());
        sizeChoice.valueProperty().bindBidirectional(model.getSize());
        shapeMenu.setItems(shapeTypesList);
    }
}