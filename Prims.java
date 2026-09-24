import java.util.Scanner;

public class Experiment6 {

    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, k, min, u, v_, sum = 0;

        System.out.print("Enter vertices: ");
        n = sc.nextInt();
        int a[][] = new int[n][n];
        int d[] = new int[n];
        int parent[] = new int[n];
        boolean v[] = new boolean[n];

        System.out.println("Enter adjacency matrix:");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        for (i = 0; i < n; i++) {
            d[i] = INF;
            parent[i] = -1;
        }
        d[0] = 0;

        for (k = 0; k < n; k++) {
            min = INF;
            u = 0;
            for (i = 0; i < n; i++)
                if (!v[i] && d[i] < min) {
                    min = d[i];
                    u = i;
                }
            v[u] = true;

            for (i = 0; i < n; i++)
                if (a[u][i] != 0 && !v[i] && a[u][i] < d[i]) {
                    d[i] = a[u][i];
                    parent[i] = u;
                }
        }

        System.out.println("Edges in MST:");
        for (i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " weight: " + a[i][parent[i]]);
            sum += a[i][parent[i]];
        }
        System.out.println("Total weight: " + sum);
    }
}
