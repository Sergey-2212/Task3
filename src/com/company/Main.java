package com.company;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 0, 1, 1, 2, 3, 0, 1};
        System.out.println(Arrays.toString(invertArray(array)));
        System.out.println(Arrays.toString(arrayFrom1To100()));
        int[] arrayTask3 = {1, 25, 34, 4, 6, 8, 1};
        System.out.println(Arrays.toString(lessThanSixMultiplyByTwo(arrayTask3)));
        squareArray(5);
        minAndMaxValueOfArray(arrayTask3);
        System.out.println("\n" + checkBalance(new int[]{2, 2, 1, 2, 6}));
        shiftArray(array,-3);
        System.out.println(Arrays.toString(array));
        shiftArray(array, 3);
        System.out.println(Arrays.toString(array));
	// write your code here
    }

    public static int[] invertArray (int[] array) {
        int[] inverted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                inverted[i] = 1;
            } else if (array[i] == 1) {
                inverted[i] = 0;
            } else {
                inverted[i] = array[i];
            }
        }
        return inverted;
    }

    public static int[] arrayFrom1To100 () {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] lessThanSixMultiplyByTwo (int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 2;
        }
                return array;
    }

    public static void squareArray(int lenght) {
        int[][] array = new int[lenght][lenght];
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                if ( i == j || i + j == lenght - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
        }

    }

    public static int[] initialArray (int len, int value) {
        int[] array = new int[len];
        Arrays.fill(array, value);
        return array;
    }

    public static void minAndMaxValueOfArray (int[] array) {
        int min = array[0];
        int max = array[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {min = array[i]; minIndex = i;}
            if (array[i] > max) {max = array[i]; maxIndex = i;}
        }
        System.out.printf("\nМинимальное значение = %d, его индекс = %d.\nМаксимальное значение = %d, его индекс = %d",min, minIndex, max, maxIndex);
    }

    public static int sumArrayFromFirstToIndexElement (int[] array,int index) {
        if (array.length < index) return 0;
        int sum = 0;
        for (int i = 0; i <= index; i++ ) {
            sum += array[i];
        } return sum;
    }

    public static int sumArrayFromIndexToLastElement (int[] array, int index) {
        if (index < 0 || index > array.length - 1) return 0;
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum += array[i];
        } return sum;
    }

    public static boolean checkBalance (int[] array) {
        boolean check = false;
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length - 1; i++) {
            a = sumArrayFromFirstToIndexElement(array, i);
            b = sumArrayFromIndexToLastElement(array, i+1);
            if (a == b) {check = true;  break;}
        }
        return check;
    }

    public static void shiftArrayLeft (int[] array, int step) {
        int helper;
        while (step < 0) {
            helper = array[0];
            for (int i = 1; i < array.length; i++) {
                array[i-1] = array[i];
            }
            array[array.length - 1] = helper;
            step++;
        }

    }

    public static void shiftArray (int[] array, int step) {
        if (step > 0) {
            shiftArrayRight(array, step);
        } else {
            shiftArrayLeft(array, step);
        }
    }

    public static void shiftArrayRight (int[] array, int step) {
        int helper;
        while (step > 0) {
            helper = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = helper;
            step--;
        }
    }
}

