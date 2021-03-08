package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FigureCircle extends Figure{

    public FigureCircle(Color borderColor, int lineThickness) {
        super(borderColor, lineThickness);
    }

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        gc.strokeOval(x[0], y[0], x[1] - x[0], y[1] - y[0]);
    }

    @Override
    public void draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        gc.strokeOval(x[0], y[0], x[1] - x[0], y[1] - y[0]);
    }

    @Override
    public void setFillColor(String color) {

    }

}
