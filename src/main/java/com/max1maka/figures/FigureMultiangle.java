package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.isNaN;

public class FigureMultiangle extends Figure{
    private List<Double> xs = new ArrayList<>();
    private List<Double> ys = new ArrayList<>();
    private List<Double> xs2 = new ArrayList<>();
    private List<Double> ys2 = new ArrayList<>();
    private int i;
    boolean isLastCoordsUsed = false;

    private double tempX = 0;
    private double tempY = 0;


    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        isClassFilled = true;
        gc.setFill(getBorderColor());
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
            gc.fillPolygon(coordX, coordY, coordY.length);
        }
        i++;

        for (int j = 0; j < coordX.length; j++) {
            System.out.println("X in draw: " + coordX[j]);
            System.out.println("Y in draw: " + coordY[j]);
        }
        System.out.println("Angles in draw: " + (i - 1));
        System.out.println("");

        setCoordinades(coordX, coordY);
        return new double[] {x[1], y[1]};
    }


    @Override
    public void preview(double[] x, double[] y,List<Double[]> lastCoords,  GraphicsContext gc) {

        gc.clearRect(0, 0, 800, 640);
        gc.setFill(getBorderColor());

        xs.clear();
        ys.clear();
        for (int j = 0; j < lastCoords.size(); j++) {
            xs.add(lastCoords.get(j)[0]);
            ys.add(lastCoords.get(j)[1]);
        }
        xs.add(x[1]);
        ys.add(y[1]);
        double[] coordX = makeAnArray(xs);
        double[] coordY = makeAnArray(ys);

        gc.fillPolygon(coordX, coordY, coordY.length);

    }

    @Override
    public void redraw(GraphicsContext gc, int param) {
        gc.setStroke(getBorderColor());
        gc.setLineWidth(getLineThickness());
        double[] x = new double[coordinades.get(0)[0].length];
        double[] y = new double[coordinades.get(0)[0].length];

        for (int m = 0; m < coordinades.get(0)[0].length; m++) {
            x[m] = coordinades.get(0)[0][m];
            y[m] = coordinades.get(0)[1][m];
            if (m > 1){
                gc.fillPolygon(x, y, (m + 1));
            }
            System.out.println("dot " + (m + 1));
        }

        for (int j = 0; j < coordinades.get(0)[0].length; j++) {
            System.out.println("X in redraw: " + coordinades.get(0)[0][j]);
            System.out.println("Y in redraw: " + coordinades.get(0)[1][j]);
        }
        System.out.println("Angles in redraw: " + coordinades.get(0)[0].length);
        System.out.println("");

   //     gc.fillPolygon(x, y, coordinades.get(0)[0].length);
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
