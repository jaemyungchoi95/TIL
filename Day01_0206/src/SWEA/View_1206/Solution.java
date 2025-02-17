package SWEA.View_1206;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        // 이번 문제의 테스트케이스는 10으로 고정
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt(); // 건물 갯수 입력
            int[] arr = new int[N]; // 건물의 높이를 담아 줄 배열
            // 배열에 건물의 높이를 담아준다
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
             
            int cnt = 0; // 세대 수를 카운트하는 변수
             
            // 첫 두 건물과 마지막 두 건물이 무조건 0이기 때문에 탐색범위 제한하여 탐색한다.
            for (int i = 2; i < N-2; i++) {
                int max = -1; // 건물의 최대값을 담아준다
                 
                // i를 기준으로 보았을 때 양옆은 점검한다
                for (int j = i-2; j <= i+2; j++) {
                    // 자기 자신은 비교에서 배제하고
                    if (i != j) {
                        // max 값을 갱신
                        max = Math.max(max, arr[j]);
                    }
                }
                // 나의 건물높이가 max값보다 크면 나의 건물높이 - max값을 더해준다
                if (arr[i] > max) cnt += arr[i] - max;
            }
            // 테스트케이스가 종료될 때마다 결과 출력
            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }
}