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
			int cnt = 1;
			// 8개의 숫자를 받아서 큐에 넣어준다
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			while (true) {
				int tempNum = queue.poll();
				if (tempNum < cnt) {
					break;
				}
				queue.add(tempNum - cnt);
				cnt++;
			}
			
			System.out.println(queue);
		
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝