import java.util.*;
import java.io.*;

public class Main {

    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        while (K!=0){

            for (int i=N-1; i>=0; i--){
                int num = arr[i];

                if (num <= K){
                    K = K - num;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
