package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.Figure;

import java.util.List;

import static java.lang.Double.NaN;

public class FigureLine extends Figure {

    @Override
    public void preview(double[] x, double[] y, List<Double[]> lastCoords, GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 640);
        gc.setStroke(Color.web(getColorS()));
        gc.setLineWidth(getLineThickness());
        gc.strokeLine(x[0], y[0], x[1], y[1]);
    }

    @Override
    public double[] draw(double[] x, double[] y, GraphicsContext gc) {
        setFigureType(2);
        gc.setStroke(Color.web(getColorS()));
        gc.setLineWidth(getLineThickness());
        gc.strokeLine(x[0], y[0], x[1], y[1]);

        setCoordinades(new double[] {x[0], x[1]}, new double[] {y[0], y[1]});
        isClassFilled = true;
        return new double[] {NaN, NaN};
    }

    @Override
    public void redraw(GraphicsContext gc) {
        gc.setStroke(Color.web(getColorS()));
        gc.setLineWidth(getLineThickness());
        gc.strokeLine(coordinades.get(0)[0][0], coordinades.get(0)[1][0],
                coordinades.get(0)[0][1], coordinades.get(0)[1][1]);
    }

}
