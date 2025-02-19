package SWEA.농작물_수확하기_2805;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 농장의 크기
			sc.nextLine(); // 개행문자 제거
			int[][] arr = new int[N][N]; // 농장 수확물을 담아줄 정수 2차원 배열
			int sum = 0; // 합계를 담아줄 변수
			
			// 배열에 수를 담아준다
			for (int i = 0; i < N; i++) {
				String[] str = sc.nextLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			// 시작인덱스와 끝 인덱스를 N/2로 지정해준다
			int startIdx = N/2;
			int endIdx = N/2;
			
			for (int i = 0; i < N; i++) {
				if (i > 0 && i < N/2) {
					startIdx -= 1;
					endIdx += 1;
				} else if (i == N/2) {
					startIdx = 0;
					endIdx = N-1;
				} else if (i > N/2) {
					startIdx += 1;
					endIdx -= 1;
				}
				
				for (int j = startIdx; j <= endIdx; j++) {
					sum += arr[i][j];
				}
			}
			
			// 테스트케이스 출력
			System.out.printf("#%d %d\n", test_case, sum);
			
		} // 테스트케이스 끝
        sc.close();
	} // main 끝
    
} // 클래스 끝

/*
1
5
14054
44250
02032
51204
52212

#1 23
 * */
