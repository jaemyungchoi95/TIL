package SWEA.계산기1_1222;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        
		// 이번 테스트케이스는 10으로 고정
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 테스트케이스의 길이
			sc.nextLine(); // 개행문자 제거
			String calc = sc.nextLine(); // 계산식을 담아줄 문자열
			
			// 먼저 계산식을 후위 표기식으로 바꿔줘야 한다
		
			// 후위 표기식을 담아줄 StringBuilder
			StringBuilder postfix = new StringBuilder();
			
			// 연산자를 담는 스택
			Stack<Character> op = new Stack<>();
			
			// 문자열의 길이만큼 순회하면서
			for (int i = 0; i < N; i++) {
				// 각 연산자의 경우 별로 담아준다.
				// 피연산자를 만났을 경우 (한자리만 입력된다고 가정)
				if (calc.charAt(i) >= '0' && calc.charAt(i) <= '9') {
					postfix.append(calc.charAt(i));
				}
				// 연산자 + 를 만나면
				else if (calc.charAt(i) == '+') {
					// 연산자 우선순위를 비교해서 처리 (작성해보기)
					while (!op.isEmpty()) {
						postfix.append(op.pop());
					}
					op.push(calc.charAt(i));
				}
			}
			
			// 마지막까지 남아있는 연산자를 체크한다.
			while (!op.isEmpty()) {
				postfix.append(op.pop());
			}
			
			// 숫자들도 스택으로 담아주기 위해 스택 선언
			Stack<Integer> nums = new Stack<>();
			
			// 후위표기식을 선회하면서
			for (int i = 0; i < postfix.length(); i++) {
				if (Character.isDigit(postfix.charAt(i))) { // 피연산자가 숫자이면 스택에 담아준다
					nums.push(postfix.charAt(i) - '0');
					// 만약 연산자이면
				} else {
					int num2 = nums.pop(); // 두번째 숫자와 첫번째 숫자를 순서대로 꺼내서
					int num1 = nums.pop();
                    nums.push(num1+num2); // 더한 숫자를 nums에 넣어준다
				}
			}
			
			// 최종적으로 남은 숫자를 꺼내서 답으로 출력한다.
			int answer = nums.pop();
			System.out.printf("#%d %d\n", test_case, answer);

		} // 테스트케이스 끝
		sc.close();
	} //main 끝
    
} // 클래스 끝