import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] walls;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        walls = new boolean[N];

        if(M ==0 ){
            System.out.println(N);
        }else{
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int startNum = Integer.parseInt(st.nextToken());
                int endNum = Integer.parseInt(st.nextToken());

                if(startNum < endNum){
                    breakWall(startNum, endNum);
                }
            }

            int cnt = 0;

            for(int i=0; i<N; i++){
                if(!walls[i]) cnt ++;
            }
            System.out.println(cnt);
        }

    }

    static void breakWall(int startNum, int endNum){
        for (int i=startNum; i<endNum; i++){
            if(!walls[i]){
                walls[i] = true;
            }
        }
    }
}