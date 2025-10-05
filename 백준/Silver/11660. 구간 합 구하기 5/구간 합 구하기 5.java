import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] S = new int [N+1][N+1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());

                S[i][j] = num + (S[i-1][j] +S[i][j-1]) - S[i-1][j-1];
            }
        }

        for (int k=0; k<M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = S[x2][y2] - (S[x2][y1-1] + S[x1-1][y2]) + S[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
