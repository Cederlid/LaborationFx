package com.example.laborationfx.controller;

import com.example.laborationfx.Shape;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class HelloShapeController {
    @FXML
    private Button squareButton;

    @FXML
    private Button circleButton;

    @FXML
    private TextField sizeField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Canvas canvas;


    ShapeModel model;

    public void initialize() {
        model = new ShapeModel();

    }
}