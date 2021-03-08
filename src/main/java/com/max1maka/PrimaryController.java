package com.max1maka;

import java.net.URL;
import java.util.*;

import com.max1maka.actions.Actionable;
import com.max1maka.figures.Figure;
import com.max1maka.figures.FigureCircle;
import com.max1maka.figures.FigureSquare;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PrimaryController implements Actionable {

    @FXML
    private Canvas canvasDraw;

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

    @FXML
    private Canvas canvasPreview;

    private double x;
    private double y;
    private List<Object> figures = new ArrayList<>();


    private Figure currentFigure;

    private Map<Double, Double> coordinates = new HashMap<>();

    @FXML
    void initialize() {
        GraphicsContext graphicsContextDraw = canvasDraw.getGraphicsContext2D();
        GraphicsContext graphicsContextPreview = canvasPreview.getGraphicsContext2D();
        canvasPreview.setVisible(false);

        imgCircle.setOnMouseClicked(event -> {
            FigureCircle circle = new FigureCircle(colorPicker.getValue(), Integer.parseInt(brushSize.getText()));
            figures.add(circle);
            currentFigure = circle;
        });

        imgSquare.setOnMouseClicked(event -> {
            FigureSquare square = new FigureSquare(colorPicker.getValue(), Integer.parseInt(brushSize.getText()));
            figures.add(square);
            currentFigure = square;
        });

        canvasDraw.setOnDragDetected(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
        });

        canvasDraw.setOnMouseDragged(event -> {
            canvasPreview.setVisible(true);
            currentFigure.preview(new double[] {x, event.getX() - x},
                    new double[] {y, event.getY() - y},
                    graphicsContextPreview);
        });

        canvasDraw.setOnMouseReleased(dragEvent -> {
            canvasPreview.setVisible(false);
            currentFigure.draw(new double[] {x, dragEvent.getX() - x},
                    new double[] {y, dragEvent.getY() - y},
                    graphicsContextDraw);
        });


    }
}




// создаем Мап "Название элемента - Класс"
// при нажатии на элемент создаем объект класса (берем его из мапа)


//TODO спросить чем отличается многоугольник от ломаной

//    GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//        graphicsContext.setFill(Color.BLACK);
//                canvas.setOnDragDetected(mouseEvent -> {
//                x = mouseEvent.getX();
//                y = mouseEvent.getY();
//                });
//                canvas.setOnMouseDragged((event) -> {
//                  graphicsContext.strokeOval(x, y, event.getX() - x, event.getY() - y);
//                });
