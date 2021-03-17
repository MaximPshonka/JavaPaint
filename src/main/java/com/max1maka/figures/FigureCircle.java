package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;

import static java.lang.Double.NaN;

public class FigureCircle extends Figure{

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        double tempX = (x[1] - x[0] > 0) ? x[1] - x[0] : x[0] - x[1];
        double tempY = (y[1] - y[0] > 0) ? y[1] - y[0] : y[0] - y[1];
        double startX = Math.min(x[0], x[1]);
        double startY = Math.min(y[0], y[1]);
        gc.strokeOval(startX, startY, tempX, tempY);
    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        colors.add(getBorderColor());
        thicks.add((int) getLineThickness());

        double tempX = (x[1] - x[0] > 0) ? x[1] - x[0] : x[0] - x[1];
        double tempY = (y[1] - y[0] > 0) ? y[1] - y[0] : y[0] - y[1];
        double startX = Math.min(x[0], x[1]);
        double startY = Math.min(y[0], y[1]);
        gc.strokeOval(startX, startY, tempX, tempY);

        //это не нужно
        setX(new double[] {startX, tempX});
        setY(new double[] {startY, tempY});

        setCoordinades(new double[] {startX, tempX}, new double[] {startY, tempY});
        return new double[] {NaN, NaN};
    }

    @Override
    public void redraw(GraphicsContext gc) {
        gc.setStroke(colors.get(figureIndex));
        gc.setLineWidth(thicks.get(figureIndex));
        gc.strokeOval(coordinades.get(figureIndex)[0][0], coordinades.get(figureIndex)[1][0],
                coordinades.get(figureIndex)[0][1], coordinades.get(figureIndex)[1][1]);
        figureIndex++;
    }

    @Override
    public void setFillColor(String color) {

    }

}
