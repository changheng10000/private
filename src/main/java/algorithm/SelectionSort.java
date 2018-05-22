package algorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int t = a[i];
                a[i] = a[minIndex];
                a[minIndex] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,1,8,1,2,9,0};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
