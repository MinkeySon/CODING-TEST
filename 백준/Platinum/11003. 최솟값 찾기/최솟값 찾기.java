import java.util.*;
import java.io.*;

public class Main {

    private static class Node{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    static StringTokenizer st;
    static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > num){
                dq.removeLast();
            }

            dq.addLast(new Node(i, num));

            if (dq.getFirst().index < i-L+1){
                dq.removeFirst();
            }

            sb.append(dq.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}
