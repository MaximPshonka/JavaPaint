package com.max1maka.actions;

import com.max1maka.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Map;

public interface Actionable {
    default void saveFile(){

    }
    default void saveFileAs(){

    }
    default void aboutProject(){

    }
    default void close(){

    }
    default void clear(){

    }
    default void addPlugin(){

    }
    default void openFromFile(){

    }

     default void undo(List<Figure> figures, List<Figure> deletedFigures, GraphicsContext graphicsContextDraw){
         if (figures.size() > 0) {
             graphicsContextDraw.clearRect(0, 0, 800, 640);
             int temp = (figures.get(figures.size() - 1).isClassFilled()) ? 1 : 2;
             for (int i = 0; i < figures.size() - temp; i++) {
                 figures.get(i).redraw(graphicsContextDraw, 0);
             }
             deletedFigures.add(figures.get(figures.size() - temp));
             if (temp == 2){
                 figures.remove(figures.get(figures.size() - 2));
             }
             figures.remove(figures.get(figures.size() - 1));
         }
    }

    default void redo(List<Figure> figures, List<Figure> deletedFigures, GraphicsContext graphicsContextDraw){
        if (deletedFigures.size() > 0) {
            deletedFigures.get(deletedFigures.size() - 1).redraw(graphicsContextDraw, 0);
            figures.add(deletedFigures.get(deletedFigures.size() - 1));
            deletedFigures.remove(deletedFigures.size() - 1);
        }
    }

}
