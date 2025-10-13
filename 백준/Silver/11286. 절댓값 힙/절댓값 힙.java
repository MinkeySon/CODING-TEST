import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b){
            int A = Math.abs(a);
            int B = Math.abs(b);
            if(A > B){
                return A - B;
            }else if(A == B){
                if (a > b){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }
    });
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(input.equals("0")){
                if(minHeap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    int e = minHeap.poll();
                    sb.append(e).append("\n");
                }
            }else{
                minHeap.add(Integer.parseInt(input));
            }
        }
        System.out.println(sb);
        br.close();
    }
}
