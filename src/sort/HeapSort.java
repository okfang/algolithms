package sort;

/**
 * Created by tjoe on 2017/3/4.
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        buildMaxHeap(arr);
        int end = arr.length - 1;
        while (end >= 0){
            swap(arr,0, end);
            end--;
            maxHeapify(arr,0,end);
        }
    }
    public static void buildMaxHeap(int[] arr){
        int startIndex = (arr.length - 1 - 1) / 2;
        for (int i = startIndex; i >= 0; i--){
            maxHeapify(arr, i, arr.length-1);
        }
    }

    public static void maxHeapify(int[] arr, int index, int end){
        int currentIndex = index;
        int max = currentIndex;
        int leftc;
        int rightc;

        while (true){
            leftc = 2*currentIndex + 1;
            rightc = 2*currentIndex + 2 ;
            if (leftc <= end && arr[max] < arr[leftc]){
                max = leftc;
            }
            if (rightc <= end && arr[max] < arr[rightc]){
                max = rightc;
            }
            if (max != currentIndex){
                swap(arr, currentIndex, max);
            }else {
                break;
            }
            currentIndex = max;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7,10 };
        print(data);
        heapSort(data);
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
