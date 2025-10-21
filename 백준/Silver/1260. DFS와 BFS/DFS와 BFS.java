import java.util.*;
import java.io.*;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] dfs_check;
    static boolean[] bfs_check;
    static StringTokenizer st;
    static ArrayList<Integer>[] lst;
    static StringBuilder dfs_sb;
    static StringBuilder bfs_sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs_sb = new StringBuilder();
        bfs_sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        lst = new ArrayList[N+1];
        dfs_check = new boolean[N+1];
        bfs_check = new boolean[N+1];

        for (int i=1; i<=N; i++){
            lst[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int first_num = Integer.parseInt(st.nextToken());
            int second_num = Integer.parseInt(st.nextToken());

            lst[first_num].add(second_num);
            lst[second_num].add(first_num);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(lst[i]);
        }

        dfs(V);
        bfs(V);

        System.out.println(dfs_sb);
        System.out.println(bfs_sb);
    }

    public static void dfs(int s){
        dfs_check[s] = true;
        dfs_sb.append(s).append(" ");

        for (int e : lst[s]){
            if (!dfs_check[e]){
                dfs(e);
            }
        }
    }

    public static void bfs(int s){
        queue.add(s);
        bfs_check[s] = true;

        while (!queue.isEmpty()){
            int num = queue.poll();
            bfs_sb.append(num).append(" ");

            for (int e : lst[num]){
                if (!bfs_check[e]){
                    queue.add(e);
                    bfs_check[e] = true;
                }
            }
        }
    }
}
