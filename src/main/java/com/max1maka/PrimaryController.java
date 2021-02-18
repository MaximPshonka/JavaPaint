package com.max1maka;

import java.net.URL;
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
    private Canvas canvas;

    @FXML
    void initialize() {
        GraphicsContext g = canvas.getGraphicsContext2D();

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
}
