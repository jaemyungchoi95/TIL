package SWEA.괄호_짝짓기_1218;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> stack = new ArrayList<>(); // ArrayList로 스택을 구현한다
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        
		// 이 문제의 테스트케이스는 10개
		for(int test_case = 1; test_case <= 10; test_case++) {
			stack.clear();
			int T = sc.nextInt(); // 테스트 문자의 길이
			sc.nextLine(); // 개행 문자 처리
			String[] arr = sc.nextLine().split("");
			// 한글자씩 받아진 배열을 탐색하면서
			for (String str : arr) {
				// 스택이 비었으면 무조건 추가
				if (isEmpty()) {
					push(str);
					// 만약 직전의 괄호가 지금 탐색하는 괄호와 동일하다면 각 경우별로 직전의 값을 제거해준다
				} else {
					if (str.equals(")") && peek().equals("(")) {
						pop();
					} else if (str.equals("}") && peek().equals("{")) {
						pop();
					} else if (str.equals("]") && peek().equals("[")) {
						pop();
					} else if (str.equals(">") && peek().equals("<")) {
						pop();
						// 모두 해당하지 않으면 요소를 넣어준다
					} else {
						push(str);
					}
				}
			}
			// 배열의 탐색이 끝났을 때 빈배열이라면 1, 남아있으면 0 출력
			if (isEmpty()) {
				System.out.printf("#%d %d\n", test_case, 1);
			} else {
				System.out.printf("#%d %d\n", test_case, 0);
			}
			
		} // 테스트케이스 끝
		sc.close();
	} // main 끝
	
	// 추가
	static void push(String value) {
		stack.add(value);
	}
	
	// 확인
	static String peek() {
//		System.out.printf("peek : %s\n", stack.get(stack.size()-1));
		return stack.get(stack.size()-1);
	}
	
	// 삭제
	static String pop() {
//		System.out.printf("pop : %s\n", stack.get(stack.size()-1));
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
