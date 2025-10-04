import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static StringTokenizer st;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if (M <= num) M = num;
            arr[i] = num;
        }

        float sum = 0;

        for(int i=0; i<N; i++){
            float n = arr[i];
            float chgNum = (n / M) * 100;
            sum += chgNum;
        }

        System.out.println(sum / N);
    }
}
