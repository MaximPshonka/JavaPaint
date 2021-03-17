package com.max1maka;

import com.max1maka.actions.Actionable;
import com.max1maka.figures.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

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
    private ImageView imgMultiangle;

    @FXML
    private Canvas canvasPreview;

    @FXML
    private HBox hBox;

    @FXML
    private Pane pane;

    private double[] coords = {NaN, NaN};

    private List<Figure> figures = new ArrayList<>();
    private List<Figure> deletedFigures = new ArrayList<>();
    private Figure currentFigure;

    @FXML
    public void initialize() {
        GraphicsContext graphicsContextDraw = canvasDraw.getGraphicsContext2D();
        GraphicsContext graphicsContextPreview = canvasPreview.getGraphicsContext2D();

        canvasPreview.setVisible(false);
        canvasDraw.setFocusTraversable(true);

        imgCircle.setOnMouseClicked(event -> {
            FigureCircle circle = new FigureCircle();
   //         figures.add(circle);
            currentFigure = circle;
        });

        imgSquare.setOnMouseClicked(event -> {
            FigureSquare square = new FigureSquare();
  //          figures.add(square);
            currentFigure = square;
        });

        imgLine.setOnMouseClicked(event -> {
            FigureLine line = new FigureLine();
   //         figures.add(line);
            currentFigure = line;
        });

        imgMultiline.setOnMouseClicked(event -> {
            FigureMultiline multiline = new FigureMultiline();
     //       figures.add(multiline);
            currentFigure = multiline;
        });

        imgTriangle.setOnMouseClicked(event -> {
            FigureTriangle triangle = new FigureTriangle();
    //        figures.add(triangle);
            currentFigure = triangle;
        });

        imgPolygon.setOnMouseClicked(event -> {
            FigurePolygon polygon = new FigurePolygon();
     //       figures.add(polygon);
            currentFigure = polygon;
        });

        imgMultiangle.setOnMouseClicked(event -> {
            FigureMultiangle multiangle = new FigureMultiangle();
     //       figures.add(multiangle);
            currentFigure = multiangle;
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        canvasDraw.setOnDragDetected(mouseEvent -> {
            if (isNaN(coords[0])) {
                coords[0] = mouseEvent.getX();
                coords[1] = mouseEvent.getY();
            }
        });

        canvasDraw.setOnMouseDragged(event -> {
            if (currentFigure != null) {
                currentFigure.setBorderColor(colorPicker.getValue());
                currentFigure.setLineThickness(Integer.parseInt(brushSize.getText()));
                canvasPreview.setVisible(true);
                currentFigure.preview(new double[]{coords[0], event.getX()},
                        new double[]{coords[1], event.getY()},
                        graphicsContextPreview);
            }
        });

        canvasDraw.setOnMouseReleased(dragEvent -> {
            if (currentFigure != null){
                currentFigure.setBorderColor(colorPicker.getValue());
                currentFigure.setLineThickness(Integer.parseInt(brushSize.getText()));
                canvasPreview.setVisible(false);
                coords = currentFigure.draw(new double[]{coords[0], dragEvent.getX()},
                        new double[]{coords[1], dragEvent.getY()},
                        graphicsContextDraw);
                canvasDraw.requestFocus();
                figures.add(currentFigure);
            }

        });

        canvasDraw.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                coords[0] = NaN;
                coords[1] = NaN;
            }
            if (keyEvent.getCode() == KeyCode.HOME){
                graphicsContextDraw.clearRect(0, 0, 800, 640);
                for (int i = 0; i < figures.size(); i++) {
                    figures.get(i).setFigureIndex(0);
                }

                for (int i = 0; i < figures.size() - 1; i++) {
                    figures.get(i).redraw(graphicsContextDraw);
                }

                deletedFigures.add(figures.get(figures.size() - 1));
                figures.remove(figures.get(figures.size() - 1));
            }
            if (keyEvent.getCode() == KeyCode.PAGE_UP){
                deletedFigures.get(deletedFigures.size() - 1).redraw(graphicsContextDraw);
                figures.add(deletedFigures.get(deletedFigures.size() - 1));
                deletedFigures.remove(deletedFigures.size() - 1);

            }
        });


    }

}
