package sort;

/**
 * Created by tjoe on 2017/3/11.
 */
public class QuickSort {

    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left > right){
            return;
        }
        int mid;

        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[leftIndex];
        int cellIndex = leftIndex;

        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[rightIndex] >= pivot){
                rightIndex--;
            }
            if (leftIndex < rightIndex && arr[rightIndex] < pivot){
                arr[cellIndex] = arr[rightIndex];
                cellIndex = rightIndex;
                leftIndex++;
            }
            while (leftIndex < rightIndex && arr[leftIndex] <= pivot){
                leftIndex++;
            }
            if (leftIndex< rightIndex && arr[leftIndex] > pivot){
                arr[cellIndex] = arr[leftIndex];
                cellIndex = leftIndex;
                rightIndex--;
            }
        }

        arr[cellIndex] = pivot;
        mid = cellIndex;

        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1, right);
    }
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7,10 };
        print(data);
        sort(data);
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
