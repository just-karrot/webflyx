import java.util.Scanner;

public class Experiment2 {

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int L[] = new int[n1], R[] = new int[n2];
        int i, j;

        for (i = 0; i < n1; i++) L[i] = arr[l + i];
        for (j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        i = 0; j = 0;
        int k = l;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
}
