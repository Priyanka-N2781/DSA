import java.util.*;

public class NumberOfIslands {
    static int rows, cols;
    static int[][] grid;
    static void dfs(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        dfs(r - 1, c); 
        dfs(r + 1, c); 
        dfs(r, c - 1); 
        dfs(r, c + 1); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }
}
