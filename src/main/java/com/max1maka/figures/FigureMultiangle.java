package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.isNaN;

public class FigureMultiangle extends Figure{
    private List<Double> xs = new ArrayList<>();
    private List<Double> ys = new ArrayList<>();
    private List<Double> xs2 = new ArrayList<>();
    private List<Double> ys2 = new ArrayList<>();
    private int i;

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        gc.setFill(getBorderColor());
        gc.setStroke(getBorderColor());
        colors.add(getBorderColor());
        thicks.add((int) getLineThickness());
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
            gc.fillOval(x[1], y[1], 1, 1);
        } else {
            gc.fillPolygon(coordX, coordY, i);
        }
        i++;
        setX(coordX);
        setY(coordY);

        setCoordinades(coordX, coordY);
        return new double[] {x[1], y[1]};
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
        gc.fillPolygon(x, y, coordinades.get(figureIndex)[0].length);
        figureIndex++;
    }

    @Override
    public void preview(double[] x, double[] y, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setFill(getBorderColor());
        gc.setStroke(getBorderColor());

        for (int j = 0; j < xs.size(); j++) {
           xs2.add(xs.get(j));
           ys2.add(ys.get(j));
        }

        xs2.add(x[1]);
        ys2.add(y[1]);
        if (i < 3) {
            gc.fillOval(x[1], y[1], 1, 1);
        } else {
            gc.fillPolygon(makeAnArray(xs2), makeAnArray(ys2), i);
        }
        xs2.clear();
        ys2.clear();
    }

    @Override
    public void setFillColor(String color) {

    }

    private double[] makeAnArray(List<Double> coords) {
        double[] arr = new double[coords.size()];
        for (int j = 0; j < coords.size(); j++) {
            arr[j] = coords.get(j);
        }
        return arr;
    }
}
