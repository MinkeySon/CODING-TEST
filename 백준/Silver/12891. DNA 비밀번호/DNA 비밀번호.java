

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 현재 윈도우의 문자 개수가 최소 조건을 만족하는지 확인하는 변수
    static int checkCount = 0;
    // 현재 윈도우의 A, C, G, T 개수를 저장하는 배열
    static int[] myArr = new int[4];
    // 최소 필요 개수를 저장하는 배열
    static int[] checkArr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        char[] A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                // 최소 필요 개수가 0이면, 이미 조건을 만족한 것으로 간주
                checkCount++;
            }
        }

        // 1. 초기 윈도우 처리 (0 ~ P-1)
        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        // 2. 첫 비밀번호 확인
        if (checkCount == 4) {
            count++;
        }

        // 3. 슬라이딩 윈도우 시작
        for (int i = P; i < S; i++) {
            int j = i - P; // 윈도우의 시작 인덱스

            // 맨 왼쪽 문자(j)는 윈도우에서 제거
            remove(A[j]);
            // 맨 오른쪽 문자(i)는 윈도우에 추가
            add(A[i]);

            // 4. 조건 만족 시 카운트 증가
            if (checkCount == 4) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 문자를 윈도우에 추가하는 함수
    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkCount++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkCount++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkCount++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkCount++;
                break;
        }
    }

    // 문자를 윈도우에서 제거하는 함수
    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkCount--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkCount--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkCount--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkCount--;
                myArr[3]--;
                break;
        }
    }
}