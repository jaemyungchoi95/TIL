package SWEA.String_1213;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 이 문제의 테스트케이스는 10개이다
		for(int test_case = 1; test_case <= 10; test_case++) {
			int tNum = sc.nextInt(); // 테스트케이스의 번호
			sc.nextLine(); // 개행문제 제거
			char[] targetStr = sc.nextLine().toCharArray(); // 찾을 문자열 => 배열로 받아줌
			int K = targetStr.length; // 찾을 문자열의 길이
			char[] str = sc.nextLine().toCharArray(); // 대상 문자열
			int N = str.length; // 대상 문자열의 길이
			int cnt = 0; // 동일한 문자열의 개수 카운트
			
			// 대상 문자열에서 찾을 문자열의 길이만큼 뺀 횟수를 돌면서
			for (int i = 0; i <= N-K; i++) {
				boolean isTrue = true; // 상태변수를 선언
				// 찾을 문자열의 길이만큼만 돌면서
				for (int j = 0; j < K; j++) {
					// 만약 str의 i번째부터 K만큼의 길이를 돌았을때 불일치하는게 나오면 상태값을 false로 바꾸고 2중 for문 종료
					if (str[i+j] != targetStr[j]) {
						isTrue = false;
						break;
					}
				}
				// 만약 일치해서 true 상태를 유지한다면 cnt를 더해줌
				if (isTrue) cnt++;
			}
			System.out.printf("#%d %d\n", tNum, cnt);
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝
