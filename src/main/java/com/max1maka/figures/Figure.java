package com.max1maka.figures;

import javafx.scene.canvas.GraphicsContext;

public abstract class Figure {

    abstract void draw(double[] x, double[] y);
    abstract void setFillColor(String color);

    private String borderColor;
    private String lineThickness;
    private GraphicsContext gc;

    // эти массивы будут заполнены после того,
    // как пользователь отпустит ЛКМ и конечный вариант фигуры будет отрисован
    private double[] x;
    private double[] y;

    public Figure(String borderColor, String lineThickness, GraphicsContext gc) {
        this.borderColor = borderColor;
        this.lineThickness = lineThickness;
        this.gc = gc;
    }

}
