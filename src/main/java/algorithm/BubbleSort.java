package algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length - i - 1; j++){
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
    }

    public static void bubbleSort2(int[] a){
        for (int i = a.length-1; i > 0 ; i--) {
            for (int j = a.length-1; j > a.length-i-1; j--){
                if(a[j-1]>a[j]){
                    int t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    //鸡尾酒排序,对冒泡排序的改进:从低到高然后从高到低
    public static void cocktailSort(int[] a){
        int n = a.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            //最大右移
            for(int i = left; i < right; i++){
                if(a[i] > a[i+1]){
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                }
            }
            right--;
            //最小左移
            for (int i = right; i > left; i--) {
                if(a[i-1]>a[i]){
                    int t = a[i-1];
                    a[i-1] = a[i];
                    a[i] = t;
                }
            }

            left++;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,1,8,1,2,9,0};
        cocktailSort(a);
        System.out.println(Arrays.toString(a));
    }
}
