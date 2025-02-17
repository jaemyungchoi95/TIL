package SWEA.쇠막대기_자르기_5432;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> stack = new ArrayList<>(); // ArrayList로 스택을 구현한다

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); // 테스트 케이스의 수
		sc.nextLine(); // 개행 문자 제거
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] arr = sc.nextLine().split(""); // 괄호를 배열로 받아준다
			
//			System.out.println(Arrays.toString(arr));
//			System.out.println(arr.length);
			
			int sum = 0; // 조각의 합계를 담아줄 변수
			String prev = ""; // 이전 괄호의 형태를 담아줄 변수
			
			// 괄호 배열을 순회하면서
			for (String str : arr) {
				// str이 ( 라면
				if (str.equals("(")) {
					push(str); // 바로 넣어준다
					// 아니라면 ) 니까 빼준다
				} else {
					pop(); // 닫는 괄호를 지워주고
					
					// 만약 직전의 괄호가 열린 괄호라면 레이저이기 때문에 남아있던 모든 ( 의 개수를 누적
					if (prev.equals("(")) {
						sum += stack.size();
						// 직전 문자가 ) 라면 쇠막대기의 끝이다
					} else {
						sum += 1;
					}
				}
				// 한개의 열을 지날때마다 이전 값 업데이트
				prev = str;
			}
			
			// 테스트케이스가 끝나면 결과 출력
			System.out.printf("#%d %d\n", test_case, sum);
			
		} // 테스트케이스 끝
        
	} // main 끝
	
	// 추가
	static void push(String value) {
		stack.add(value);
	}
	
	// 확인
	static String peek() {
		return stack.get(stack.size()-1);
	}
	
	// 삭제
	static String pop() {
		if (stack.isEmpty()) return "";
		return stack.remove(stack.size()-1);
	}
	
	// 빈 배열 확인
	static boolean isEmpty() {
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
} // 클래스 끝
