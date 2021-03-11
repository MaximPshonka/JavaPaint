package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Double.NaN;

public class FigurePolygon extends Figure{
    public FigurePolygon(Color borderColor, int lineThickness) {
        super(borderColor, lineThickness);
    }

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());

        double tempX = (x[1] - x[0]) / 2 + x[0];

        double[] xs = new double[] {tempX - 0.25 * (x[1] - x[0]), x[0], tempX, x[1], tempX + 0.25 * (x[1] - x[0])};
        double[] ys = new double[] {y[1], (y[1] - y[0]) / 2 + y[0], y[0], (y[1] - y[0]) / 2 + y[0], y[1]};
        gc.strokePolygon(xs, ys, 5);
    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());

        double tempX = (x[1] - x[0]) / 2 + x[0];

        double[] xs = new double[] {tempX - 0.25 * (x[1] - x[0]), x[0], tempX, x[1], tempX + 0.25 * (x[1] - x[0])};
        double[] ys = new double[] {y[1], (y[1] - y[0]) / 2 + y[0], y[0], (y[1] - y[0]) / 2 + y[0], y[1]};
        gc.strokePolygon(xs, ys, 5);

        setX(xs);
        setY(ys);
        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }
}
