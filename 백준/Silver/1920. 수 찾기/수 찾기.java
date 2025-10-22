import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수 입력 횟수

        String input1 = br.readLine();
        StringTokenizer st = new StringTokenizer(input1, " ");

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            hashSet.add(tmp);
        }

        int M = Integer.parseInt(br.readLine()); // 수 입력 횟수

        String input2 = br.readLine();
        st = new StringTokenizer(input2, " ");

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(hashSet.contains(tmp)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}