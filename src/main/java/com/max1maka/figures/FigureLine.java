package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static java.lang.Double.NaN;

public class FigureLine extends Figure{

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        gc.strokeLine(x[0], y[0], x[1], y[1]);
    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        gc.strokeLine(x[0], y[0], x[1], y[1]);

        setX(new double[] {x[0], x[1]});
        setY(new double[] {y[0], y[1]});
        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }
}
