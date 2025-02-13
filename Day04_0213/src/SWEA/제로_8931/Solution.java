package SWEA.제로_8931;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> stack = new ArrayList<>(); // ArrayList로 스택을 구현하려고 한다
//	static int top = -1; // stack이 비어있으면 -1임
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			stack.clear();
			int K = sc.nextInt(); // 영수증의 수
			int sum = 0; // 가격의 합
			
			// 영수증의 수를 받아주는데
			for (int i = 0; i < K; i++) {
				int n = sc.nextInt(); // n번째 영수증 금액
				// 만약 정수가 0이라면 최근에 쓰고 지우지 않았던 수를 지워야 한다.
				// 0이 아닌수는 기록해준다.
				if (n != 0) {
					push(String.valueOf(n));
//					System.out.printf("n != 0 stack 현황 : %s\n", stack);
				} else {
					pop();
//					System.out.printf("n == 0 stack 현황 : %s\n", stack);
				}
				
			}
			
			for (String num : stack) {
				sum += Integer.parseInt(num);
			}
				
			System.out.printf("#%d %d\n",test_case, sum);
			
		} // 테스트케이스 끝
		
	} // main 끝
	
	// 삽입
	static void push(String value) {
		// 배열이니까 해야하는 검사
//		if(isFull()) {
//			System.out.println("가득 차있어.... 미안해");
//			// 여기에서든 full에서든 우리가 만드는 커스텀이니
//			// 배열의 크기를 두배로 늘려서 다시 복사해도 좋아요!!
//			return false;
//		}
//		top++;
		// 위 검사는 ArrayList라서 생략한다
		stack.add(value); // ArrayList에서 add를 하면 맨 뒤에 추가된다.
	}
	
	// 삭제
	static String pop() {
		if (isEmpty()) {
			System.out.println("뺄 것이 없어 미안해~~");
			return null;
		}
		return stack.remove(stack.size()-1);
	}
	
	// 조회
	static String Peek() {
		if (isEmpty()) {
			System.out.println("공백인데?");
			return null;
		}
		
		return stack.get(stack.size()-1);
	}
	
	// 공백
	static boolean isEmpty() {
//		if (top == -1)
//			return true;
//		else
//			return false;
	
//		if (top == -1)
//			return true;
//		return false;
		
		return stack.size() == 0;
	}
	// 포화(Full)
//	static  boolean isFull() {
//		return top == stack.length - 1;
//	}
	// ArrayList는 포화가 없기때문에 생략
	
} // 클래스 끝
