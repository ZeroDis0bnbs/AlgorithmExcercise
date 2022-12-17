package Sort;

public class BottomUpMergeSort {
    private static int[] aux;

    public BottomUpMergeSort(int[] arr) {
        sort(arr);
    }

    private void sort(int[] arr) {
        aux = new int[arr.length];
        for (int size = 1; size < arr.length; size *= 2) {
            for (int lo = 0; lo < arr.length - size; lo += size * 2) {
                merge(arr, lo, lo + size - 1, Math.min(lo + size * 2 - 1, arr.length - 1));
            }
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        System.arraycopy(arr, lo, aux, lo, hi - lo + 1);
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > hi)
                arr[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
    }

    private boolean less(int num1, int num2) {
        return num1 < num2;
    }
}
