package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure {

    public Figure(Color borderColor, int lineThickness) {
        this.borderColor = borderColor;
        this.lineThickness = lineThickness;
    }

    abstract public double[] draw(double[] x, double[] y, GraphicsContext gc);
    abstract public void preview(double[] x, double[] y, GraphicsContext gc);
    abstract public void setFillColor(String color);

    private Color borderColor;
    private int lineThickness;
    private GraphicsContext gc;

    // эти массивы будут заполнены после того,
    // как пользователь отпустит ЛКМ и конечный вариант фигуры будет отрисован
    private double[] x;
    private double[] y;

    protected void setX(double[] x) {
        this.x = x;
    }

    protected void setY(double[] y) {
        this.y = y;
    }

    protected Color getBorderColor() {
        return borderColor;
    }

    protected double getLineThickness() {
        return lineThickness;
    }
}
