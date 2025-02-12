package SWEA.초심자의_회문_검사_1989;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next(); // 회문 대상 문자열
			int N = str.length(); // 문자열의 길이
			StringBuilder sb = new StringBuilder();
			
			// 문자열을 역순으로 돌면서 sb에 담아준다
			for (int i = N-1; i >= 0; i--) {
				sb.append(str.charAt(i));
			}
			
			// 만약 str과 sb가 일치한다면 1을 반환하고 아니면 0을 반환한다
			if (str.equals(sb.toString())) {
				System.out.printf("#%d %d\n", test_case, 1);
			} else {
				System.out.printf("#%d %d\n", test_case, 0);
			} // 반복문 끝
		}
	} // main 끝
} // 클래스 끝
