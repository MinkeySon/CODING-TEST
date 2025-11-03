import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() != 1){
            int a = pq.remove();
            int b = pq.remove();

            sum += a+b;
            pq.add(a + b);
        }

        System.out.println(sum);
    }
}
