package SWEA.계산기1_1222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//1222. [S/W 문제해결 기본] 6일차 - 계산기1
public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
     
		// 이번 테스트케이스는 10으로 고정
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt(); // 문자열의 길이
			sc.nextLine(); // 개행문자 제거
			String calcStr = sc.nextLine(); // 계산을 담아줄 변수
			
			Stack<Character> op = new Stack<>(); // 연산자를 담아줄 스택
			Queue<Integer> nums = new LinkedList<>(); // 숫자를 담아줄 ArrayList 선언
			int sum = 0; // 합계를 담아줄 변수 선언
			
			// 문자열의 길이만큼 반복하면서
			for (int i = 0; i < T; i++) {
				// 만약 + 라면 스택에 담아주고
				if (calcStr.charAt(i) == '+') {
					op.push(calcStr.charAt(i));
				}
				// 글자가 '0' 보다 크고 '9'보다는 작다면
				else if (calcStr.charAt(i) >= '0' && calcStr.charAt(i) <= '9') {
					nums.add((int)calcStr.charAt(i)-'0');
				}
			}
			
			System.out.println(nums);
			System.out.println(op);
			
			int amount = 0; // 합계 결과를 담아줄 변수
			
			for (int i = 0; i < nums.size(); i++) {
				
			}

			// 정답 출력
//			System.out.printf("#%d %d\n",test_case, T);
		} // 테스트케이스 끝
     
	} //main 끝
 
} // 클래스 끝