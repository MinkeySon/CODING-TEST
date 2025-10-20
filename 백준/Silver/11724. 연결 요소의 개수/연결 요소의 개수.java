import java.util.*;
import java.io.*;

public class Main {

    public static Stack<Integer> stack = new Stack<>();
    static boolean[] check;
    static int[][] arr;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int rst = 0;

    public static void main (String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int linked = Integer.parseInt(st.nextToken());

            arr[node][linked] = linked;
            arr[linked][node] = node;
        }

        for (int i=1; i<=N; i++){
            int result = dfs(i);

            if (result > 0 ){
                rst++;
            }
        }

        br.close();
        System.out.println(rst);
    }

    public static int dfs(int s){

        if (check[s]){
            return 0;
        }

        int cnt = 0;

        stack.push(s);
        check[s] = true;

        while(!stack.isEmpty()){
            int e = stack.pop();
            cnt++;

            check[e] = true;

            for(int tmp : arr[e]){
                if (tmp != 0 && !check[tmp]){
                    stack.push(tmp);
                    check[tmp] = true;
                }
            }
        }

        return cnt;
    }
}
