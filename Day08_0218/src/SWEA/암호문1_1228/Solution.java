package SWEA.암호문1_1228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 이번 테스트케이스는 10개로 고정 됨
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 암호문의 길이
			sc.nextLine(); // 개행문자 제거
			ArrayList<String> codeArr = new ArrayList<>(Arrays.asList(sc.nextLine().split(" "))); // 암호문 배열
			
			int C = sc.nextInt(); // 명령문의 길이
			sc.nextLine(); // 개행문자 제거
			Queue<Integer> qRange = new LinkedList<>(); // 범위를 담아줄 정수 큐
			Queue<String> qCode = new LinkedList<>(); // 코드들을 담아줄 정수 큐
			
			// 명령문을 문자배열로 받아준다
			String[] cmd = sc.nextLine().split(" ");
			
			for (int i = 0; i < cmd.length; i++) {
				// 만약 2자리 이하의 숫자라면 범위를 담아주는 큐에 정수로 변환하여 넣어주고
				if (Character.isDigit(cmd[i].charAt(0)) && cmd[i].length() <= 2) {
					qRange.add(Integer.parseInt(cmd[i]));
				}
				// 만약 6자리라면 암호문으로 하여 코드 배열에 넣어준다
				else if (Character.isDigit(cmd[i].charAt(0)) && cmd[i].length() == 6) {
					qCode.add(cmd[i]);
				}
			}
			
			// 범위가 담긴 큐가 빌때까지 돌아주는데
			while(!qRange.isEmpty()) {
				int idx = qRange.poll(); // 첫번째 숫자는 넣을 인덱스
				int amt = qRange.poll(); // 넣어야 할 암호의 갯수
				
				// amt만큼 돌면서
				for (int i = 0; i < amt; i++) {
					// codeArr에 담아주는데 idx부터 1씩 증가하는 인덱스에 차례대로 넣어준다.
					codeArr.add(idx++, qCode.poll());
				}
			}
			
			// 문자열 변환을 위한 StringBuilder 선언
			StringBuilder sb = new StringBuilder();
			
			// 10개까지만 담아준다
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(codeArr.get(i));
			}
			
			// 정답 출력
			System.out.printf("#%d%s\n", test_case, sb);
			
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝