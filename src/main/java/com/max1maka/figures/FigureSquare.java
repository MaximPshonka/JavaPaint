package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

public class FigureSquare extends Figure{
    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        double tempX = (x[1] - x[0] > 0) ? x[1] - x[0] : x[0] - x[1];
        double tempY = (y[1] - y[0] > 0) ? y[1] - y[0] : y[0] - y[1];
        double startX = Math.min(x[0], x[1]);
        double startY = Math.min(y[0], y[1]);
        gc.strokeRect(startX, startY, tempX, tempY);

    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        double tempX = (x[1] - x[0] > 0) ? x[1] - x[0] : x[0] - x[1];
        double tempY = (y[1] - y[0] > 0) ? y[1] - y[0] : y[0] - y[1];
        double startX = Math.min(x[0], x[1]);
        double startY = Math.min(y[0], y[1]);
        gc.strokeRect(startX, startY, tempX, tempY);

        setX(new double[] {x[0], x[1] - x[0]});
        setY(new double[] {y[0], y[1] - y[0]});
        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }
}
