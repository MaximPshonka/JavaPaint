package com.max1maka;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox isBrush;

    @FXML
    private CheckBox isEllipse;

    @FXML
    private CheckBox isSquare;

    @FXML
    private CheckBox isTriangle;

    @FXML
    private CheckBox isEraser;

    @FXML
    private CheckBox isStraight;

    @FXML
    private Canvas canvas;

    @FXML
    void initialize() {

        ArrayList<CheckBox> list = new ArrayList<>();
        list.add(isEraser); list.add(isStraight);
        list.add(isSquare); list.add(isBrush);
        list.add(isTriangle); list.add(isEllipse);

        //методы, нужные чтобы убирать галочки со всех чекбоксов, когда выбирается другой чекбокс
        // (только один чекбокс может быть активен)
        isEraser.setOnMouseClicked(e -> leaveOneSelector(list, isEraser));
        isStraight.setOnMouseClicked(e -> leaveOneSelector(list, isStraight));
        isSquare.setOnMouseClicked(e -> leaveOneSelector(list, isSquare));
        isTriangle.setOnMouseClicked(e -> leaveOneSelector(list, isTriangle));
        isEllipse.setOnMouseClicked(e -> leaveOneSelector(list, isEllipse));
        isBrush.setOnMouseClicked(e -> leaveOneSelector(list, isBrush));

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);

        //рисуем линию
        drawLine(gc, 10, 30, 790, 30);

        //рисуем круг с заливкой
        drawFilledCircle(gc, 10, 60, 90, 90);

        //овал без заливки
        drawStrokedCircle(gc, 110, 60, 130, 90);

        //квадрат, закрашенный градиентом
        drawSquare(gc, 10, 180, 130, 130, 0, 0, Color.RED, Color.YELLOW);

        //песочные часы
        drawTriangles(gc, new double[]{30, 100, 30, 100}, new double[]{330, 330, 380, 380}, 4);

        //буква Z
        drawZ(gc, new double[]{360, 520, 360, 520}, new double[]{90, 90, 240, 240}, 4);

        drawS2(gc, 400, 300, 300, 200, 70, 70, Color.CYAN, Color.BLACK, Color.RED, Color.BLUE);


    }

    private void drawLine(GraphicsContext gc, float startX, float startY, float endX, float endY) {
        gc.strokeLine(startX, startY, endX, endY);
    }

    private void drawFilledCircle(GraphicsContext gc, float startX, float startY, float circleW, float circleH) {
        gc.fillOval(startX, startY, circleW, circleH);
    }

    private void drawStrokedCircle(GraphicsContext gc, float startX, float startY, float circleW, float circleH) {
        gc.strokeOval(startX, startY, circleW, circleH);
    }

    private void drawSquare(GraphicsContext gc, double startX,
                            double startY, double w,
                            double h, double aw,
                            double ah, Color c1, Color c2) {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
                CycleMethod.REFLECT,
                new Stop(0.0, c1),
                new Stop(1.0, c2)));
        gc.fill();
        gc.fillRoundRect(startX, startY, w, h, aw, ah);
    }

    private void drawTriangles(GraphicsContext gc, double[] d1, double[] d2, int i) {
        gc.strokePolygon(d1, d2, i);
    }

    private void drawZ(GraphicsContext gc, double[] d1, double[] d2, int i){
        gc.setLineWidth(41);
        gc.strokePolyline(d1, d2, i);
    }

    private void drawS2(GraphicsContext gc, double startX,
                        double startY, double w,
                        double h, double aw,
                        double ah, Color c1, Color c2,
                        Color c3, Color c4) {
        gc.setFill(new RadialGradient(0, 0, 0.7, 0.2, 0.1, true,
                CycleMethod.REFLECT,
                new Stop(0.0, c1),
                new Stop(1.0, c2)));
        gc.fill();
        gc.fillRoundRect(startX, startY, w, h, aw, ah);
    }



    private void leaveOneSelector(ArrayList<CheckBox> list, CheckBox active) {
        for (CheckBox i: list){
            if (i != active){
                i.setSelected(false);
            }
        }


    }
}


////рисование кривых линий и их стирание
//        canvas.setOnMouseDragged(e -> {
//                GraphicsContext g = canvas.getGraphicsContext2D();
//                double size = Double.parseDouble(brushSize.getText());
//                double y = e.getY() - size / 2;
//                double x = e.getX() - size / 2;
//
//                if (isEraser.isSelected()){
//                g.clearRect(x, y, size, size);
//                }
//                else if (isBrush.isSelected()){
//                g.setFill(colorPicker.getValue());
//                g.fillRect(x, y, size, size);
//                }
//                });
