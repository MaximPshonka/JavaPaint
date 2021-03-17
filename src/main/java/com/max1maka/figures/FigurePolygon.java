package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;

import static java.lang.Double.NaN;

public class FigurePolygon extends Figure{

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

    // здесь ломается, почему - непонятно

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        colors.add(getBorderColor());
        thicks.add((int) getLineThickness());

        double tempX = (x[1] - x[0]) / 2 + x[0];

        double[] xs = new double[] {tempX - 0.25 * (x[1] - x[0]), x[0], tempX, x[1], tempX + 0.25 * (x[1] - x[0])};
        double[] ys = new double[] {y[1], (y[1] - y[0]) / 2 + y[0], y[0], (y[1] - y[0]) / 2 + y[0], y[1]};
        gc.strokePolygon(xs, ys, 5);

        setX(xs);
        setY(ys);

        setCoordinades(xs, ys);
        return new double[] {NaN, NaN};
    }

    @Override
    public void redraw(GraphicsContext gc) {
        gc.setStroke(colors.get(figureIndex));
        gc.setLineWidth(thicks.get(figureIndex));

        double[] x = new double[coordinades.get(figureIndex)[0].length];
        double[] y = new double[coordinades.get(figureIndex)[0].length];
        for (int i = 0; i < coordinades.get(figureIndex)[0].length; i++) {
            x[i] = coordinades.get(figureIndex)[0][i];
            y[i] = coordinades.get(figureIndex)[1][i];
        }
        gc.strokePolygon(x, y, 5);
        figureIndex++;
    }

    @Override
    public void setFillColor(String color) {

    }
}
