import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static StringBuilder sb;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args ) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int max = 1;

        for (int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());

            if (max <= input){
                while(max <= input){
                    stack.push(max);
                    sb.append("+").append("\n");
                    max++;
                }
                stack.pop();
                sb.append("-").append("\n");
            }

            else{
                if (stack.isEmpty()){
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                else if (stack.peek() != input){
                    break;
                }
                stack.pop();
                sb.append("-").append("\n");
            }
        }
            if (stack.isEmpty()){
                System.out.println(sb);
            }else{
                System.out.println("NO");
            }
        }
}
