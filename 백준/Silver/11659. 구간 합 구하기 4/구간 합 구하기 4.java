

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] sArr = new int[N+1];

        st = new StringTokenizer(br.readLine(), " "); // 입력 값

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            sArr[i] = sArr[i-1] + num;
        }

        for(int k=0; k<M; k++){

            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sArr[j] - sArr[i-1]);
        }
    }
}
