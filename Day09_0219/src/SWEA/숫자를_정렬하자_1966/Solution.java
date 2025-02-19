package SWEA.숫자를_정렬하자_1966;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 숫자의 개수
			int[] arr = new int[N]; // 숫자 배열
			StringBuilder sb = new StringBuilder(); // 숫자 출력을 위한 sb 선언
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); // 입력되는 숫자를 배열에 담아준다
			}
			// 배열 오름차순 정렬
			Arrays.sort(arr);
			
			// 오름차순 된 배열을 sb에 순차적으로 담아준다
			for (int i = 0; i < N; i++) {
				sb.append(" ").append(arr[i]);
			}
			
			// 답안 출력
			System.out.printf("#%d%s\n", test_case, sb);

		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝

/* 
1
5
1 4 7 8 0

#1 0 1 4 7 8 
*/