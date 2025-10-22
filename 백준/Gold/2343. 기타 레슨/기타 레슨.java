import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if (start < num){start = num;}
            end += num;

            arr[i] = num;
        }

        while(start <= end){
            int middle = (start+end) / 2;

            int count = 0;
            int sum = 0;

            for (int i=0; i<N; i++){
                if (sum + arr[i] > middle){
                    count++;
                    sum = 0;
                }

                sum += arr[i];
            }
            if (sum != 0){
                count ++;
            }

            if (count > M){
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}
