package Fifth_work;

import java.util.Arrays;

/**
 * @author qlizihang
 * @date 2023/6/6 14:05
 * @description:  用java语言实现冒泡排序、插入排序、快速排序、合并排序、堆排序
 */
public class SortWays {
    static int[] arr = new int[]{4,1,7,9,8,2,15,17,9,2};
    public static void main(String[] args) {

        System.out.print("冒泡排序：");
        bubbleSort(arr.clone());

        System.out.print("\n插入排序：");
        insertSort(arr.clone());

        System.out.print("\n快速排序：");
        int[] temp = arr.clone();
        quickSort(temp,0,temp.length-1 );
        for (int i=0;i< temp.length;i++){
            System.out.print(temp[i] + " ");
        }

        System.out.print("\n合并排序:");
        int tem[] = arr.clone();
        mergeSort(tem);
        for (int i=0;i< tem.length;i++){
            System.out.print(tem[i] + " ");
        }

        System.out.print("\n堆排序:");
        int[] temp1 = arr.clone();
        heapSort(temp1);
        for (int i=0;i< temp1.length;i++){
            System.out.print(temp1[i] + " ");
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right, pivot = arr[left];
            while (i < j) {
                while (i < j && arr[j] > pivot) j--;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] <= pivot) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = pivot;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
    //合并排序
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n<2){
            return;
        }
        int mid = n/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);
        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }
    public static void merge(int[] arr, int[] left,int[] right) {
        int i = 0, j = 0, k = 0;
        int nl = left.length, nr = right.length;
        while (i < nl && j < nr) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i<nl){
            arr[k++] = left[i++];
        }
        while (j<nr){
            arr[k++] = right[j++];
        }
    }

    //堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // 调整堆
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int root, int len) {
        int left = root * 2 + 1, right = root * 2 + 2;
        int maxIndex = root;
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != root) {
            swap(arr, root, maxIndex);
            heapify(arr, maxIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
