package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

public class FigureTriangle extends Figure{
    public FigureTriangle(Color borderColor, int lineThickness) {
        super(borderColor, lineThickness);
    }

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());

        double[] xs = new double[] {x[0], (x[1] - x[0]) / 2 + x[0], x[1]};
        double[] ys = new double[] {y[1], y[0], y[1]};
        gc.strokePolygon(xs, ys, 3);
    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());

        double[] xs = new double[] {x[0], (x[1] - x[0]) / 2 + x[0], x[1]};
        double[] ys = new double[] {y[1], y[0], y[1]};
        gc.strokePolygon(xs, ys, 3);

        setX(xs);
        setY(ys);
        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }
}
