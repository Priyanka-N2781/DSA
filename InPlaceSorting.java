import java.util.*;

public class InPlaceSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        int right = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
