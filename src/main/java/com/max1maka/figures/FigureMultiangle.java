package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

public class FigureMultiangle extends Figure{
    private List<Double> xs = new ArrayList<>();
    private List<Double> ys = new ArrayList<>();
    private int i;

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setFill(getBorderColor());
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        if (isNaN(x[0])){
            xs.clear();
            ys.clear();
            i = 1;
        }
        xs.add(x[1]);
        ys.add(y[1]);
        double[] coordX = makeAnArray(xs);
        double[] coordY = makeAnArray(ys);
        if (i < 3) {
            gc.fillOval(xs.get(xs.size() - 1), ys.get(ys.size() - 1), 1, 1);
        } else {
            gc.fillPolygon(coordX, coordY, i);
        }
        i++;
        setX(coordX);
        setY(coordY);
        return new double[] {x[1], y[1]};
    }

    private double[] makeAnArray(List<Double> coords) {
        double[] arr = new double[coords.size()];
        for (int j = 0; j < coords.size(); j++) {
            arr[j] = coords.get(j);
        }
        return arr;
    }

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {

    }

    @Override
    public void setFillColor(String color) {

    }
}
