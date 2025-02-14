package SWEA.계산기3_1224;

import java.util.HashMap;
import java.util.Map;
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
			
			// 연산자의 우선순위를 정해서 HashMap에 담아준다
			// key가 중복되면 안되기 때문에 Key에 연산자, Value에 우선순위를 담아준다
			Map<Character, Integer> priority = new HashMap<>();
			priority.put('(', 0);
			priority.put('+', 1);
			priority.put('-', 1);
			priority.put('*', 2);
			priority.put('/', 2);
		
			// 후위 표기식을 담아줄 StringBuilder
			StringBuilder postfix = new StringBuilder();
			
			// 연산자를 담는 스택
			Stack<Character> op = new Stack<>();
			
			// 문자열의 길이만큼 순회하면서
			for (int i = 0; i < N; i++) {
				// 각 연산자의 경우 별로 담아준다.
				// 열린 괄호를 만나면
				if (calc.charAt(i) == '(') {
					// 일단 스택에 담아준다
					op.push(calc.charAt(i));
				}
				// 만약 닫은괄호를 만나면
				else if (calc.charAt(i) == ')') {
					// 여는 괄호를 만날 때 까지, 꺼내고 버린다
					while(op.peek() != '(') {
						postfix.append(op.pop());
					}
					// 맨 위에있는 여는 소괄호를 버려준다.
					op.pop();
				}
				// 피연산자를 만났을 경우 (한자리만 입력된다고 가정)
				else if (calc.charAt(i) >= '0' && calc.charAt(i) <= '9') {
					postfix.append(calc.charAt(i));
				}
				// 연산자
				else {
					// 공백일때
					if (op.isEmpty()) {
						op.push(calc.charAt(i));
						// 공백이 아닐때
					} else {
						// 연산자 우선순위를 비교해서 처리 (작성해보기)
						while (priority.get(op.peek()) >= priority.get(calc.charAt(i)) && !op.isEmpty()) {
							postfix.append(op.pop());
						}
						op.push(calc.charAt(i));
					}
				}
			} // 중위표기를 하나씩 읽어서 처리
			// 중위표기로 변환된 내용 출력해본다
			System.out.printf("중위표기 : %s\n");

		} // 테스트케이스 끝
        
	} //main 끝
    
} // 클래스 끝
