import java.util.*;

class RecursiveBubbleSort {
    static void bubble(int[] arr, int i, int n) {
        if (i == n - 1) {
            return;
        }
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        bubble(arr, i + 1, n);
    }

    static void bubbleSort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        bubble(arr, 0, n);
        bubbleSort(arr, n - 1);
    }

    static void print(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + " ");
        print(arr, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr, n);
        print(arr, 0);
    }
}
