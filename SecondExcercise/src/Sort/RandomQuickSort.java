package Sort;

public class RandomQuickSort {
    public RandomQuickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
                return;
        int pt = partition(arr, lo, hi);
        sort(arr, lo, pt - 1);
        sort(arr, pt + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int el = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (less(arr[++i], el)) {
                if (i == hi)
                    break;
            }
            while (less(el, arr[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return  j;
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
