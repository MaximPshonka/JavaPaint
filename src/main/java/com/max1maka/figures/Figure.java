package com.max1maka.figures;

public abstract class Figure {
    String color;
    double lineThickness;
    long startX;
    long startY;

    public abstract void draw();

    public void undo(){

    }

    public void redo(){

    }

    public Figure(String color, double lineThickness, long startX, long startY) {
        this.color = color;
        this.lineThickness = lineThickness;
        this.startX = startX;
        this.startY = startY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLineThickness() {
        return lineThickness;
    }

    public long getStartX() {
        return startX;
    }

    public void setStartX(long startX) {
        this.startX = startX;
    }

    public long getStartY() {
        return startY;
    }

    public void setStartY(long startY) {
        this.startY = startY;
    }

    public void setLineThickness(double lineThickness) {
        this.lineThickness = lineThickness;
    }

}
