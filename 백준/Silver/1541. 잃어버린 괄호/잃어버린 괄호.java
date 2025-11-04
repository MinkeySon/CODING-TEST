import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] minusArr = input.split("-");

        // 첫번째는 다 + 처리
        String plus = minusArr[0];
        String[] plusArr = plus.split("\\+");
        for(String e : plusArr){
            sum += Long.parseLong(e);
        }

        for(int i=1; i<minusArr.length; i++){
            String[] minusTmp = minusArr[i].split("\\+");

            for(String e : minusTmp){
                sum -= Long.parseLong(e);
            }
        }
        System.out.println(sum);
    }
}