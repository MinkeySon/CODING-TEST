import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String input = br.readLine();

        String [] arr = input.split("");

        Arrays.sort(arr, (o1,o2)->{
            int firstNum = Integer.parseInt(o1);
            int secondNum = Integer.parseInt(o2);

            if (firstNum > secondNum){
                return -1;
            }else if (firstNum < secondNum){
                return 1;
            }else {
                return 0;
            }
        });

        for (String s : arr){
            sb.append(s);
        }

        System.out.println(sb);
    }
}
