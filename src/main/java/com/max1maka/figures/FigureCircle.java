package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

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
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        gc.strokeOval(x[0], y[0], x[1] - x[0], y[1] - y[0]);

        setX(new double[] {x[0], x[1] - x[0]});
        setY(new double[] {y[0], y[1] - y[0]});
        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }

}
