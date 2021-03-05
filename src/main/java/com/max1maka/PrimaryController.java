package com.max1maka;

import java.net.URL;
import java.util.ResourceBundle;

import com.max1maka.actions.Actionable;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PrimaryController implements Actionable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private GridPane gridInstruments;

    @FXML
    private ImageView imgBrush;

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
    private ImageView imgPencil;

    @FXML
    private ImageView imgPolygon;

    @FXML
    private ImageView imgStar;

    @FXML
    private ImageView imgEraser;

    @FXML
    private ImageView imgFill;

    @FXML
    private ImageView imgAdd;

    @FXML
    private ImageView imgDottedLine;

    @FXML
    void initialize() {

    }
}
