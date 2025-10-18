import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 시간제한 3초
 * 1. 입력 원소 배열원소를 저장 할 필요가 없다.
 * 2. 10,000 이 제일 큰수로 정해져 있어서 counting Array 의 사이즈를 정할 수 있다.
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] countList = new int[10001]; // 카운팅 배열 추가

        for(int i=0; i<N; i++){
            int e = Integer.parseInt(br.readLine());
            countList[e] ++;
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<countList.length; i++){
            while(countList[i] != 0){
                sb.append(i).append("\n");
                countList[i] --;
            }
        }
        System.out.println(sb);
    }
}