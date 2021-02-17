package ru.fda.dz;

public class MyArraySizeException extends NegativeArraySizeException{
    public MyArraySizeException() {
        super("Неверный размер массива");
    }
}
