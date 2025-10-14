import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        for (int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }

        for (int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                int firstNum = arr[j];
                int secondNum = arr[j+1];

                if (firstNum > secondNum){
                    int tmpNum = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmpNum;
                }
            }
        }

        for (int n : arr){sb.append(n).append("\n");}

        System.out.println(sb);
    }
}
