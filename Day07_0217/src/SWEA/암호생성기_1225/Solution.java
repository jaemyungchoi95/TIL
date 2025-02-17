package SWEA.암호생성기_1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 이 문제의 테스트케이스는 10으로 고정
		for(int test_case = 1; test_case <= 10; test_case++) {
			sc.nextInt(); // 테스트케이스의 번호
			Queue<Integer> queue = new LinkedList<>(); // 숫자를 담아줄 큐 선언
			StringBuilder sb = new StringBuilder(); // 정답을 출력해줄 스트링빌더 선언
			
			int cnt = 0; // 순환횟수 통제를 위한 변수 선언
			
			// 8개의 숫자를 받아서 큐에 넣어준다
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			boolean isTrue = true; // while문을 통제해줄 bool변수 선언
			// 목적 달성까지 반복하면서
			while (isTrue) {
				cnt++; // 한번 반복시마다 cnt를 증가시킨다
				int tempNum = queue.poll(); // 변수를 꺼내 임시로 저장할 변수 선언
				// 만약 꺼낸번호와 현재 cnt값의 차가 0보다 크면
				if (tempNum - cnt > 0) {
					// queue에 꺼낸 숫자와 cnt의 차를 담아주고
					queue.add(tempNum - cnt);
					// 만약 꺼낸 숫자와 cnt의 차가 0 이하라면
				} else if (tempNum - cnt <= 0) {
					// queue에 0으로 더해주고
					queue.add(0);
					isTrue = false; // while문을 멈추기 위해 
				}
				// 이번 연산에서 cnt가 5가 되었을 경우 cnt를 다시 0으로 바꿔준다
				if (cnt == 5) {
					cnt = 0;
				}
			}
			
			// queue가 빌때까지 값을 차례대로 꺼내어 sb에 추가해준다.
			while (!queue.isEmpty()) {
				sb.append(" ").append(queue.poll());
			}
			
			// 정답 출력
			System.out.printf("#%d %s\n", test_case, sb);
		
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝
/*
1
10 6 12 8 9 4 1 3

 * */