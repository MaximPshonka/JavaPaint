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

    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {

        return new double[] {NaN, NaN};
    }

    @Override
    public void setFillColor(String color) {

    }
}
