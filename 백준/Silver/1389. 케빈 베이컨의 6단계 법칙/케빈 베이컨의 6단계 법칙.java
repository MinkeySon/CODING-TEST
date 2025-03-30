import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1].add(v2);
            map[v2].add(v1);
        }

        int result = Integer.MAX_VALUE;
        int user = 0;
        for(int i=1; i<=N; i++){
            int e = bfs(i);
            if(result > e){
                result = e;
                user = i;
            }
        }
        System.out.println(user);
    }
    static int bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[N+1];
        boolean[] check = new boolean[N+1];

        queue.add(v);
        check[v] = true;

        while(!queue.isEmpty()){
            int e = queue.poll();
            check[e] = true;

            for(int tmp : map[e]){
                if(!check[tmp]){
                    check[tmp] = true;
                    count[tmp] = count[e] + 1;
                    queue.add(tmp);
                }
            }
        }
        int sum = 0;
        for(int e : count){
            sum += e;
        }
        return sum;
    }
}
