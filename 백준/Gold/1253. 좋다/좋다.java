import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        for (int i=0; i<N; i++){
            int targetNum = arr[i];
            int start = 0;
            int end = N-1;

            while (start != end){
                long sum = arr[start] + arr[end];

                if (sum == targetNum){
                    if (start != i && end != i){
                        count++;
                        break;
                    }else if (start == i){
                        start++;
                    }else if (end == i){
                        end--;
                    }
                }else {
                    if (sum < targetNum){
                        start ++;
                    }else{
                        end --;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
