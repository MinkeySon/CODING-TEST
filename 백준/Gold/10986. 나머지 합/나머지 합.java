import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++){
            long tmp = arr[i] % M;

            if (tmp == 0){result++;}
            arr[i] = tmp;
        }

        long[] check = new long[M];

        for (int i=1; i<=N; i++){
            int index = (int) arr[i];

            check[index]++;
        }

        for (long e : check){
            if (e != 0){
                result = result + (e * (e-1)) / 2;
            }
        }

        System.out.println(result);
    }
}