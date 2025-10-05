import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static BufferedReader br;
    static StringTokenizer st;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++){

            int startNum = arr[i];

            for (int j=i+1; j<N; j++){
                int sum = startNum + arr[j];

                if(sum == M){
                    cnt++; break;
                }
                else if(sum > M){
                    break;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
