import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int value;
        int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> dq = new LinkedList<>();

        for (int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > now){
                dq.removeLast();
            }

            dq.addLast(new Node(now, i));

            if(dq.getFirst().index <= i-L){
                dq.removeFirst();
            }

            bw.write(dq.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }
}
