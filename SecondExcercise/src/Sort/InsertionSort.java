package Sort;

public class InsertionSort {
    public InsertionSort(int[] arr) {
        sort(arr);
    }

    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //将当前元素插入到左边已经升序排列的数组中
            for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                    exch(arr, j, j-1);
            }
        }
    }

    private boolean less(int num1, int num2) {
        return num1 < num2;
    }

    private void exch(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
