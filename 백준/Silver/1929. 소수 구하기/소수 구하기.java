import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        boolean[] check = new boolean[N+1];

        for (int i=0; i<=N; i++){
            arr[i] = i;
        }

        check[0] = true;
        check[1] = true;

        for (int i=2; i<=N; i++){
            int tmpNum = arr[i];

            if(check[tmpNum]){
                continue;
            }

            int step = 2;

            while (tmpNum * step <= N){
                check[tmpNum * step] = true;
                step++;
            }
        }

        for (int i=M; i<=N; i++){
            int num = arr[i];

            if (!check[num]){
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }
}
