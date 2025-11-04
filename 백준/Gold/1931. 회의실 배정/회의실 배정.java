import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] arr = new int[N][2];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] S, int[] E){
                if(S[1] == E[1]){
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });

        int count = 0;
        int end = -1;
        for(int i=0; i<N; i++){
            if(arr[i][0] >= end){
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
