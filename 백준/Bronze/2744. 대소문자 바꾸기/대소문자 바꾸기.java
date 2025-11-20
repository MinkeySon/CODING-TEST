import java.util.*;
import java.io.*;

public class Main {

    public static String solution(String input){

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if (Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
            }else{
                c = Character.toUpperCase(c);
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(solution(input));
    }
}
