import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] moveX = {-1, 1, -2, 2, -1,1};
    static int[] moveY = {-2,-2, 0, 0, 2, 2};
    static boolean[][] visited;
    static Pos start;
    static Pos end;

    static class Pos{
        int x;
        int y;

        public Pos(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int [N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        System.out.println(bfs(start));
    }

    static int bfs(Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while(!queue.isEmpty()){
            Pos cur = queue.poll();

            for(int i=0; i<6; i++){
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];

                if(nextX >=0 && nextX < map.length && nextY >=0 && nextY < map.length && !visited[nextY][nextX]){
                    if(nextX == end.x && nextY == end.y){
                        return map[cur.y][cur.x] + 1;
                    }

                    visited[nextY][nextX] = true;
                    queue.add(new Pos(nextY,nextX));
                    map[nextY][nextX] = map[cur.y][cur.x] + 1;
                }
            }
        }
        return -1;
    }
}