package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Figure implements Serializable {
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    abstract public double[] draw(double[] x, double[] y, GraphicsContext gc);
    abstract public void redraw(GraphicsContext gc, int param);
    abstract public void preview(double[] x, double[] y, List<Double[]> lastCoords, GraphicsContext gc);
    abstract public void setFillColor(String color);

    transient private Color borderColor;
    private int lineThickness;

    protected boolean isClassFilled = false;

    public boolean isClassFilled() {
        return isClassFilled;
    }
    public void setIfsClassNew(){
        isClassFilled = false;
    }

    protected List<double[][]> coordinades = new ArrayList<>();

    protected void setCoordinades(double[] x, double[] y) {
        double[][] coord = {x, y};
        coordinades.clear();
        coordinades.add(coord);
    }

    protected Color getBorderColor() {
        return borderColor;
    }

    protected double getLineThickness() {
        return lineThickness;
    }


}
