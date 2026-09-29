import java.util.*;

class Main {
    static void dfs(int v, int[][] g, boolean[] vis) {
        vis[v] = true;
        for (int i = 0; i < g.length; i++)
            if (g[v][i] == 1 && !vis[i])
                dfs(i, g, vis);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] g = new int[n][n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u][v] = 1;
            g[v][u] = 1;
        }

        boolean[] vis = new boolean[n];
        dfs(0, g, vis);

        for (boolean x : vis) {
            if (!x) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
