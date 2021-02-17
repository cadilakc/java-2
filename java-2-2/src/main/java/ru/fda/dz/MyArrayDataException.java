package ru.fda.dz;

public class MyArrayDataException extends NumberFormatException{
    private int indexX;
    private int indexY;

    public MyArrayDataException(int indexX, int indexY) {
        super("Был обнаружен неверный элемент массива на позиции: " + indexX + " , " + indexY);
        this.indexX = indexX;
        this.indexY = indexY;
    }
}
