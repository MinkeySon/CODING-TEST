import java.util.*;

class Solution {
    static class Point{
        int x;
        int y;
        int distance;
        
        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    static int[] upDown = {0,0,1,-1};
    static int[] leftRight = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Point> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        
        int answer = 0;
        
        int start_x = 0;
        int start_y = 0;
        int start_d = 1;
           
        check[0][0] = true;
        q.add(new Point(start_x, start_y, start_d));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.x == n-1 && p.y == m-1){
                return p.distance;
            }
            
            check[p.x][p.y] = true;
            
            for(int i=0; i<4; i++){
                int move_x = p.x + upDown[i];
                int move_y = p.y + leftRight[i];
                
                if(checkPoint(move_x, move_y, n, m)){
                    if(!check[move_x][move_y] && maps[move_x][move_y] == 1){
                        check[move_x][move_y] = true;
                        q.add(new Point(move_x, move_y, p.distance + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    static boolean checkPoint(int move_x, int move_y, int n, int m){
        return move_x >= 0 && move_y >= 0 && move_x <= n-1 && move_y <= m-1;
    }
}