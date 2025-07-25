import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] moveY = {0, 0, 1, -1};
    static int[] moveX = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    static int N;
    static int M;
    static BufferedReader br;
    static StringTokenizer st;
    static int result = 0;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        // 배열 범위 지정
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];

        // 맵 형성
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");

            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        Node node = new Node(0,0);
        bfs(node);

        System.out.println(map[N-1][M-1]);
    }

    static void bfs(Node node){
        check[node.x][node.y] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;

            for(int i=0; i<4; i++){
                int movedRow = x + moveX[i];
                int movedCol = y + moveY[i];

                if(isAvailable(movedRow, movedCol)){
                    queue.add(new Node(movedRow, movedCol));
                    check[movedRow][movedCol] = true;
                    map[movedRow][movedCol] = map[x][y] + 1;
                }
            }
        }

    }

    static boolean isAvailable(int x, int y){
        if(x >= 0 && y >= 0 && x<N && y<M){
            return !check[x][y] && map[x][y] == 1;
        }else{
            return false;
        }
    }


}
