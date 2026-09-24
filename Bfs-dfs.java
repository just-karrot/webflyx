import java.util.*;

public class Experiment4 {

    static void bfs(int adj[][], int n, int start) {
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v = 0; v < n; v++) {
                if (adj[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        System.out.println();
    }

    static void dfsUtil(int adj[][], int n, int u, boolean visited[]) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v = 0; v < n; v++)
            if (adj[u][v] == 1 && !visited[v])
                dfsUtil(adj, n, v, visited);
    }

    static void dfs(int adj[][], int n, int start) {
        boolean visited[] = new boolean[n];
        System.out.print("DFS: ");
        dfsUtil(adj, n, start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, start;

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();
        int adj[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                adj[i][j] = sc.nextInt();

        System.out.print("Enter starting vertex: ");
        start = sc.nextInt();

        bfs(adj, n, start);
        dfs(adj, n, start);
    }
}
