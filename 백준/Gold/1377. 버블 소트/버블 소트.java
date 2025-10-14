import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;

    public static class Node{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> lst = new ArrayList<>();

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            lst.add(new Node(i,num));
        }

        Collections.sort(lst, (o1, o2)->{
            if (o1.value > o2.value){
                return 1;
            }else if (o1.value < o2.value) {
                return -1;
            }else{
                return 0;
            }
        });

        int max = 0;

        for (int i=0; i<N; i++){
            if (i <= lst.get(i).index){
                int tmp = lst.get(i).index - i;

                if (max < tmp){
                    max = tmp;
                }
            }
        }

        System.out.println(max + 1);
    }
}
