package com.max1maka.actions;

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
    // сюда передается список объектов всех фигур
    // после чего будет определяться класс последнего объекта
    // (последний объект сохранятся и возвращается для случая, если его
    // нужно будет восстановить методом redo()) и сам объект будет очищаться,
    // тем самым удаляясь с полотна
     default Object undo(List<Object> figures){

        return null;
    }
    // сюда передается объект, возвращенный в предыдущем методе
    // и отрисовывается заново
    default void redo(Object figure){

    }

}
