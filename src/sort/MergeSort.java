package sort;

import java.lang.reflect.Array;

/**
 * Created by tjoe on 2017/3/4.
 */
public class MergeSort {
    public static int[] temp;

    public static void mergeSort(int[] arr){
        sort(arr, 0, arr.length -  1);
    }

    public static void sort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int mid = (left + right) >>> 1;

        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);

        print(arr);
        System.out.printf("left:%d, mid:%d, right:%d\n",left,mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] temparr = new int[right - left + 1];
        int tempindex = 0;

        int midright = mid + 1;
        int arrleft = left;

        while (left <= mid && midright <= right){
            if(arr[left] <= arr[midright]){
                temparr[tempindex++] = arr[left++];
            }else{
                temparr[tempindex++] = arr[midright++];
            }
        }

        while (left <= mid){
            temparr[tempindex++] = arr[left++];
        }

        while (midright <= right){
            temparr[tempindex++] = arr[midright++];
        }

        System.arraycopy(temparr, 0, arr, arrleft, temparr.length);

    }

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        mergeSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
