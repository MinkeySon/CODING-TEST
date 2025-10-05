import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static BufferedReader br;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int [] arr = new int[N+1];

        for (int i=1; i<=N; i++){
            arr[i] = i;
        }

        for (int start = 1; start<=N; start++){
            int startNum = arr[start];
            if(startNum == N) {cnt++; break;}
            int tmpSum = 0;
            tmpSum += startNum;

            for (int step = start+1; step<=N; step++){
                tmpSum += arr[step];

                if(tmpSum == N){
                    cnt++; break;
                }

                else if (tmpSum > N){
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
