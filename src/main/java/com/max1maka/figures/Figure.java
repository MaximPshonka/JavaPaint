package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Figure implements Serializable {

    private int figureType;

    public int getFigureType() {
        return figureType;
    }

    public void setFigureType(int figureType) {
        this.figureType = figureType;
    }

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    abstract public double[] draw(double[] x, double[] y, GraphicsContext gc);
    abstract public void redraw(GraphicsContext gc, int param);
    abstract public void preview(double[] x, double[] y, List<Double[]> lastCoords, GraphicsContext gc);
    abstract public void setFillColor(String color);

    private String colorS;
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

    public void setBorderColor(Color borderColor) {
        colorS = toRGBCode(borderColor);
    }

    public String getColorS() {
        return colorS;
    }


    protected double getLineThickness() {
        return lineThickness;
    }

    protected static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }


}
