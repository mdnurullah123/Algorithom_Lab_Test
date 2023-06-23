/*MargeSort*/
package margesort;

/**
 *
 * @author MD. NURULLAH
 */
public class MargeSort {

 
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = { 9, 3, 6, 2, 1, 8, 4, 7, 5 };
        mergeSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
