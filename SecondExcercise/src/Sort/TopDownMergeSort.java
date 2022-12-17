package Sort;

public class TopDownMergeSort {
    private static int[] aux;
    public TopDownMergeSort(int[] arr) {
        sort(arr);
    }

    private void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
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

    private void exch(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
