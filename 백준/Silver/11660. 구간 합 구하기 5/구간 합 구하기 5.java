

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num + (arr[i-1][j] + arr[i][j-1]) - arr[i-1][j-1];
            }
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = arr[x2][y2] - (arr[x1-1][y2] + arr[x2][y1-1]) + arr[x1-1][y1-1];

            System.out.println(result);
        }
    }
}
