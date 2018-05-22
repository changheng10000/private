package algorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertion = a[i];

            int j = i-1;
            while (j >= 0 && a[j] > insertion){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = insertion;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,1,8,1,2,9,0};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
