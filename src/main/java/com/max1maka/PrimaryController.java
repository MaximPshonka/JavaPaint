package com.max1maka;

import java.net.URL;
import java.util.*;

import com.max1maka.actions.Actionable;
import com.max1maka.figures.Figure;
import com.max1maka.figures.FigureCircle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PrimaryController implements Actionable {

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private GridPane gridInstruments;

    @FXML
    private ImageView imgCircle;

    @FXML
    private ImageView imgSquare;

    @FXML
    private ImageView imgLine;

    @FXML
    private ImageView imgTriangle;

    @FXML
    private ImageView imgMultiline;

    @FXML
    private ImageView imgPolygon;

    @FXML
    private ImageView imgFill;

    @FXML
    private ImageView imgAdd;

    private double x;
    private double y;
    private List<Object> figures = new ArrayList<>();

    @FXML
    void initialize() {

    }
}


//    GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//        graphicsContext.setFill(Color.BLACK);
//                canvas.setOnDragDetected(mouseEvent -> {
//                x = mouseEvent.getX();
//                y = mouseEvent.getY();
//                });
//                canvas.setOnMouseDragged((event) -> {
//                graphicsContext.strokeOval(x, y, event.getX() - x, event.getY() - y);
//                });
