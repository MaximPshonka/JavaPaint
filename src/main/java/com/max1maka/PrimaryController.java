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
        GraphicsContext g = canvas.getGraphicsContext2D();

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

        //рисование кривых линий и их стирание
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double y = e.getY() - size / 2;
            double x = e.getX() - size / 2;

            if (isEraser.isSelected()){
                g.clearRect(x, y, size, size);
            }
            else if (isBrush.isSelected()){
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
        });


    }

    private void leaveOneSelector(ArrayList<CheckBox> list, CheckBox active) {
        for (CheckBox i: list){
            if (i != active){
                i.setSelected(false);
            }
        }

    }
}
