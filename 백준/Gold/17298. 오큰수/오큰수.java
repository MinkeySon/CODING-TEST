import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[N];

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);

        for (int i=1; i<N; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for (int tmp : ans){
            bw.write(tmp + " ");
        }

        bw.flush();
        bw.close();
    }
}
