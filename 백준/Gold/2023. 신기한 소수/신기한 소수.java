import java.util.*;
import java.io.*;

public class Main {

    public static Stack<Integer> stack = new Stack<>();
    public static BufferedReader br;
    public static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    static void dfs(int e, int n){
        if (n == N){
            if (isPrime(e)){
                System.out.println(e);
            }
            return;
        }

        for (int i=1; i<10; i++){
            if (i % 2 == 0){
                continue;
            }

            if (isPrime(e * 10 + i)){
                dfs(e * 10 +i, n +1);
            }
        }
    }

    static boolean isPrime(int n){
        for (int i=2; i<=n/2; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
