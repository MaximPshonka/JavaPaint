package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    abstract public double[] draw(double[] x, double[] y, GraphicsContext gc);
    abstract public void redraw(GraphicsContext gc);
    abstract public void preview(double[] x, double[] y, GraphicsContext gc);
    abstract public void setFillColor(String color);

    private Color borderColor;
    private int lineThickness;
    protected List<Color> colors = new ArrayList<>();
    protected List<Integer> thicks = new ArrayList<>();

    private GraphicsContext gc;

    protected int figureIndex;
    protected int figureIndexFromTheEnd;

    public void setFigureIndex(int figureIndex) {
        this.figureIndex = figureIndex;
    }

    public void setFigureIndexFromTheEnd() {
        this.figureIndexFromTheEnd = coordinades.size() - figureIndex;
    }

    // эти массивы будут заполнены после того,
    // как пользователь отпустит ЛКМ и конечный вариант фигуры будет отрисован
    protected double[] x;
    protected double[] y;
    protected List<double[][]> coordinades = new ArrayList<>();

    protected void setX(double[] x) {
        this.x = x;
    }

    protected void setY(double[] y) {
        this.y = y;
    }

    protected void setCoordinades(double[] x, double[] y) {
        double[][] coord = {x, y};
        coordinades.add(coord);
    }

    protected Color getBorderColor() {
        return borderColor;
    }

    protected double getLineThickness() {
        return lineThickness;
    }
}
