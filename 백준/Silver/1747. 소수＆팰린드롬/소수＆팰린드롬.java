import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean checkPal(int n){
        char[] temp = String.valueOf(n).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        while (s < e){
            if (temp[s] != temp[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int MAX_RANGE = 1_004_000;
        int[] arr = new int[MAX_RANGE]; // 0 ~ 1,003,999

        for (int i=2; i < arr.length; i++){
            arr[i] = i;
        }

        // 1은 소수가 아님
        arr[1] = 0;

        for (int i=2; i < Math.sqrt(arr.length); i++){
            if (arr[i] == 0){
                continue;
            }
            for (int j=i+i; j < arr.length; j=j+i){
                arr[j] = 0;
            }
        }

        int i = N;

        while(true){

            int checkNum = arr[i];

            if (checkNum != 0){
                if (checkPal(checkNum)){
                    System.out.println(checkNum);
                    break;
                }
            }
            i++;
        }
    }
}

