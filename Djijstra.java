import java.util.Scanner;

public class Experiment5 {

    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, k, min, u, s;

        System.out.print("Enter vertices: ");
        n = sc.nextInt();
        int a[][] = new int[n][n];
        int d[] = new int[n];
        boolean v[] = new boolean[n];

        System.out.println("Enter adjacency matrix:");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.print("Enter source: ");
        s = sc.nextInt();

        for (i = 0; i < n; i++) d[i] = a[s][i];
        d[s] = 0;
        v[s] = true;

        for (k = 1; k < n; k++) {
            min = INF;
            u = s;
            for (i = 0; i < n; i++)
                if (!v[i] && d[i] < min) {
                    min = d[i];
                    u = i;
                }
            v[u] = true;
            for (i = 0; i < n; i++)
                if (!v[i] && d[u] + a[u][i] < d[i])
                    d[i] = d[u] + a[u][i];
        }

        System.out.println("Shortest distances from source " + s + ":");
        for (i = 0; i < n; i++)
            System.out.println("Vertex " + i + ": " + d[i]);
    }
}
