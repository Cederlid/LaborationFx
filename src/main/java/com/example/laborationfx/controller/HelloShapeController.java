package com.example.laborationfx.controller;

import com.example.laborationfx.Svg;
import com.example.laborationfx.shape.ShapeType;
import com.example.laborationfx.ShapesModel;
import com.example.laborationfx.shape.Shape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloShapeController {

    public Canvas canvas;

    public ChoiceBox<ShapeType> shapeMenu;
    public Slider sizeChoice;
    public CheckBox selectMode;
    public Button undoButton;
    public Button redoButton;
    public Button svgButton;
    public AnchorPane anchorPane;

    FileChooser fileChooser = new FileChooser();
    private Shape shapeSelected;

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
        shapeMenu.setValue(model.getSelectedShapeType());
        model.getSize().addListener((observableValue, old, newValue) ->
                changeSizeOnSelected(newValue.doubleValue()));
        model.getColor().addListener((observableValue, color, newColor) ->
                changeColorOnSelected(newColor));
        selectMode.selectedProperty().addListener((observableValue, aBoolean, isSelect) -> {
            if (!isSelect) shapeSelected = null;
        });
        undoButton.setOnAction((e) -> {
            model.undo();
            refreshCanvas();
        });
        redoButton.setOnAction((event -> {
            model.redo();
            refreshCanvas();
        }));
        svgButton.setOnAction((event -> {
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("SVG files(*.svg)","*.svg");
            fileChooser.getExtensionFilters().add(extensionFilter);
            fileChooser.setTitle("Export file");
            Stage stage =(Stage) anchorPane.getScene().getWindow();
            File file = fileChooser.showSaveDialog(stage);

            if (file != null){
                var svg = new Svg();
                svg.saveToFile(model.getShapes(),file);
            }

        }));
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        if (!selectMode.isSelected()) {
            Shape shape = Shape.createShape(shapeMenu.getValue(), model.getColor().getValue(), mouseEvent.getX(), mouseEvent.getY(), model.getSize().getValue());
            model.addShape(shape);
            model.printShapeList();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(shape.getColor());
            shape.draw(gc);
        } else {
            shapeSelected = model.findShapeAt(mouseEvent.getX(), mouseEvent.getY());
            System.out.println("new selected" + shapeSelected);
        }

    }

    private void refreshCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        model.getShapes().forEach(shape -> shape.draw(gc));
    }


}