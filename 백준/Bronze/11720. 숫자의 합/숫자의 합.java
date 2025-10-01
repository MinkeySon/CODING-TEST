import java.util.*;
import java.io.*;


public class Main {

    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        String numbers = br.readLine();

        String[] numArr = numbers.split("");
        int sum = 0;

        for(int i=0; i<numArr.length; i++){
            sum += Integer.parseInt(numArr[i]);
        }

        System.out.println(sum);
    }
}
