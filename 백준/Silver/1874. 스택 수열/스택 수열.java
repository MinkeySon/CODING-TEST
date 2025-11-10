import java.util.*;
import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 1;

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if (max <= num){
                while(max <= num){
                    stack.push(max);
                    sb.append("+").append("\n");
                    max++;
                }
                sb.append("-").append("\n");
                stack.pop();
            }else{
                if (stack.isEmpty()){
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }else if (stack.peek() != num){
                    break;
                }
                stack.pop();
                sb.append("-").append("\n");
            }

        }

        if(stack.isEmpty()){
           System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
