package SWEA.암호문1_1228;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 이번 테스트케이스는 10개로 고정 됨
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 암호문의 길이
			ArrayList<Integer> arr = new ArrayList<>();
			
			// 암호문을 입력받는다
			for (int i = 0; i < N; i++) {
				arr.add(sc.nextInt());
			}
			
			int C = sc.nextInt(); // 명령문의 길이
			sc.nextLine(); // 개행문자 제거
			
			// 명령문을 문자배열로 받아준다
			String[] cmd = sc.nextLine().split(" ");
			Queue<Integer> q = new LinkedList<>();

			for (int i = 1; i < cmd.length; i++) {
				if (isDi cmd[i])
			}
			
			
			// 정답 출력
			System.out.printf("#%d %s\n", test_case, arr);
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝