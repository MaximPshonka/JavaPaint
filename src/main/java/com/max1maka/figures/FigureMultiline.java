package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class FigureMultiline extends Figure{
    private List<Double> xs = new ArrayList<>();
    private List<Double> ys = new ArrayList<>();

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
        colors.add(getBorderColor());
        thicks.add((int) getLineThickness());
        gc.strokeLine(x[0], y[0], x[1], y[1]);

        xs.add(x[0]); xs.add(x[1]);
        ys.add(y[0]); ys.add(y[1]);
        setX(getArrayFromList(xs));
        setY(getArrayFromList(ys));

        setCoordinades(getArrayFromList(xs), getArrayFromList(ys));

        return new double[] {x[1], y[1]};
    }

    @Override
    public void redraw(GraphicsContext gc) {
        gc.setStroke(colors.get(figureIndex));
        gc.setLineWidth(thicks.get(figureIndex));

        double startX = coordinades.get(figureIndex)[0][coordinades.get(figureIndex)[1].length - 2];
        double startY = coordinades.get(figureIndex)[1][coordinades.get(figureIndex)[1].length - 2];;
        double tempX = coordinades.get(figureIndex)[0][coordinades.get(figureIndex)[1].length - 1];;
        double tempY = coordinades.get(figureIndex)[1][coordinades.get(figureIndex)[1].length - 1];;

        gc.strokeLine(startX, startY, tempX, tempY);
        figureIndex++;

    }

    @Override
    public void setFillColor(String color) {

    }

    private double[] getArrayFromList(List<Double> list){
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}