package Sort;

public class ThreeWayPartitionQuickSort {
    public ThreeWayPartitionQuickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo, i = lo + 1, gt = hi, el = arr[lo];
        while (i <= gt) {
            int cmp = compare(arr[i], el);
            if (cmp < 0)
                exch(arr, lt++, i++);
            else if (cmp > 0)
                exch(arr, gt--, i);
            else
                i++;
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private int compare(int num1, int num2) {
        return num1 - num2;
    }

    private void exch(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
