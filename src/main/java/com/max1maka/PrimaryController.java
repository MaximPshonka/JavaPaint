package com.max1maka;

import com.max1maka.actions.Actionable;
import com.max1maka.figures.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ImageView imgMultiangle;

    @FXML
    private ImageView imgFill;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Canvas canvasPreview;

    @FXML
    private HBox hBox;

    @FXML
    private Pane pane;

    private List<Figure> deletedFigures = new ArrayList<>();
    private List<Figure> figures = new ArrayList<>();
    private Figure currentFigure;
    private List<Double[]> lastCoords = new ArrayList<>();
    private double[] coords = {NaN, NaN};

    @FXML
    public void initialize() {
        GraphicsContext graphicsContextDraw = canvasDraw.getGraphicsContext2D();
        GraphicsContext graphicsContextPreview = canvasPreview.getGraphicsContext2D();

        canvasPreview.setVisible(false);
        canvasDraw.setFocusTraversable(true);

        imgCircle.setOnMouseClicked(event -> {
            figures.add(new FigureCircle());
            currentFigure = new FigureCircle();
            lastCoords.clear();
        });

        imgLine.setOnMouseClicked(event -> {
            figures.add(new FigureLine());
            currentFigure = new FigureLine();
            lastCoords.clear();
        });

        imgSquare.setOnMouseClicked(event -> {
            figures.add(new FigureSquare());
            currentFigure = new FigureSquare();
            lastCoords.clear();
        });

        imgMultiline.setOnMouseClicked(event -> {
            figures.add(new FigureMultiline());
            currentFigure = new FigureMultiline();
            lastCoords.clear();
        });

        imgTriangle.setOnMouseClicked(event -> {
            figures.add(new FigureTriangle());
            currentFigure = new FigureTriangle();
            lastCoords.clear();
        });

        imgPolygon.setOnMouseClicked(event -> {
            figures.add(new FigurePolygon());
            currentFigure = new FigurePolygon();
            lastCoords.clear();
        });

        imgMultiangle.setOnMouseClicked(event -> {
            figures.add(new FigureMultiangle());
            currentFigure = new FigureMultiangle();
            lastCoords.clear();
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
                        new double[]{coords[1], event.getY()}, lastCoords,
                        graphicsContextPreview);
            }
        });

        canvasDraw.setOnMouseReleased(dragEvent -> {
            if (currentFigure != null){
                if (figures.size() > 0 && figures.get(figures.size() - 1).isClassFilled()) {
                    makeLastFigureCopy();
                }
                lastCoords.add(new Double[] {dragEvent.getX(), dragEvent.getY()});
                figures.get(figures.size() - 1).setBorderColor(colorPicker.getValue());
                figures.get(figures.size() - 1).setLineThickness(Integer.parseInt(brushSize.getText()));
                canvasPreview.setVisible(false);
                coords = figures.get(figures.size() - 1).draw(new double[]{coords[0], dragEvent.getX()},
                        new double[]{coords[1], dragEvent.getY()},
                        graphicsContextDraw);
                canvasDraw.requestFocus();
                if (deletedFigures.size() != 0){
                    deletedFigures.clear();
                }
            }
        });

        canvasDraw.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                coords[0] = NaN;
                coords[1] = NaN;
                lastCoords.clear();
                makeLastFigureCopy();
            }
            if (keyEvent.getCode() == KeyCode.HOME){
                undo(figures, deletedFigures, graphicsContextDraw);
            }
            if (keyEvent.getCode() == KeyCode.PAGE_UP) {
                redo(figures, deletedFigures, graphicsContextDraw);
            }
        });

    }

    public void makeLastFigureCopy(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = null;
        try {
            ous = new ObjectOutputStream(baos);
            ous.writeObject(figures.get(figures.size() - 1));
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //сохранили состояние объекта в поток и закрыли его

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //создаем копию последней фигуры и инициализируем состоянием предыдущей
        Figure newFigure = null;
        try {
            newFigure = (Figure)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        };
        figures.add(newFigure);
        figures.get(figures.size() - 1).setIfsClassNew();
    }

}


//    Field[] fields = this.getClass().getDeclaredFields();
//        for(Field f : fields){
//                Class t = f.getType();
//                if (t == ImageView.class && !f.getName().equals("imgFill") && !f.getName().equals("imgAdd") ){
//        figuresMap.put(f.getName(), new );
//        }
//        }
