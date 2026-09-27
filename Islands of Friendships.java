import java.util.*;
public class Islands {

    static void dfs(int[][] arr, boolean[] visited,int current){
        visited[current] = true;
        for(int i=0;i<arr.length;i++){
            if(arr[current][i] == 1 && !visited[i]){
                dfs(arr,visited,i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[] visited = new boolean[n];
        int groups = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                groups++;
                dfs(arr,visited,i);
            }
        }
        System.out.println(groups);
    }
    
}
