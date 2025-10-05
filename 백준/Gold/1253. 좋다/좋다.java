import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int target = 0; target<N; target ++) {
            long targetNum = arr[target];

            int start = 0;
            int step = N - 1;

            while (start < step) {
                long sum = arr[start] + arr[step];

                if (sum == targetNum) {
                    if (start != target && step != target) {
                        cnt++;
                        break;
                    } else if (start == target) {
                        start++;

                    } else {
                        step --;
                    }
                }
                else if(sum < targetNum){
                    start ++;
                }
                else {
                    step --;
                }
            }
        }
        System.out.println(cnt);
    }
}
