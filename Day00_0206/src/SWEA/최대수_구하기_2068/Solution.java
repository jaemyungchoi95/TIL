package SWEA.최대수_구하기_2068;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();  // 테스트 케이스의 수
		
     // 테스트케이스만큼 돌아준다
		for(int test_case = 1; test_case <= T; test_case++) {
			int max = 0; // 최대값을 담아줄 변수
			
			// 10개의 숫자를 입력받으면서
			for (int i = 0; i < 10; i++) {
				int N = sc.nextInt();
				// max값에 바로 더 큰값을 담아준다
				if (max < N) {
					max = N;
				}
			}
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
