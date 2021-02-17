package ru.fda.dz;

public class MainApp {

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}, //для проверки 4
                //{"1", "2", "3", "4"}, //для проверки 5 и более
                //{"1", "a", "3", "4"}, //для проверки с буквой
        };
        sumArr(arr);
    }

    public static void sumArr(String[][] arr) {
        try {
            if (arr.length < 4 || arr.length > 4 || arr[arr.length - 1].length < 4 || arr[arr.length - 1].length > 4) {
                throw new MyArraySizeException();
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        int n = Integer.parseInt(arr[i][j]);
                        sum += n;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}