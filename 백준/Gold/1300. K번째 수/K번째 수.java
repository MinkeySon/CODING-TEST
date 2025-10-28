import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;
        long result = 0;

        while (start <= end){

            long middle = (start + end) / 2;
            long count = 0;

            for (int i=1; i<=N; i++){
                long num = Math.min(middle / i, N);

                count += num;
            }

            if (count < K){
                start = middle + 1;
            }else{
                result = middle;
                end = middle -1;
            }
        }

        System.out.println(result);
    }
}
