import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<Integer>[] lst;
    static boolean[] visited;
    static boolean found;
    static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader (new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new ArrayList[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++){
            lst[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer (br.readLine());
            int first_friend = Integer.parseInt(st.nextToken());
            int second_friend = Integer.parseInt(st.nextToken());

            lst[first_friend].add(second_friend);
            lst[second_friend].add(first_friend);
        }

        found = false;

        for (int i=0; i<N; i++){
            dfs (i,1);

            if(found){
                System.out.println(1);
                return;
            }

        }
        System.out.println(0);

    }

    static void dfs(int num, int depth){
        if(depth == 5){
            found = true;
            return;
        }

        visited[num] = true;

        for (int e : lst[num]){
            if(!visited[e]){
                dfs(e, depth+1);
            }
        }

        visited[num] = false;
    }
}
