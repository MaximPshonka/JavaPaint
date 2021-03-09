package com.max1maka.figures;

import com.max1maka.PrimaryController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Double.NaN;

public class FigureMultiline extends Figure{
    List<Double> xs = new ArrayList<>();
    List<Double> ys = new ArrayList<>();

    public FigureMultiline(Color borderColor, int lineThickness) {
        super(borderColor, lineThickness);
    }

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
        gc.strokeLine(x[0], y[0], x[1], y[1]);

        xs.add(x[0]); xs.add(x[1]);
        ys.add(y[0]); ys.add(y[1]);
        setX(getArrayFromList(xs));
        setY(getArrayFromList(ys));
        
        return new double[] {x[1], y[1]};
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