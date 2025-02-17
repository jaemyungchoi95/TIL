package SWEA.String_1213;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 이 문제의 테스트케이스는 10개이다
		for(int test_case = 1; test_case <= 10; test_case++) {
			int tNum = sc.nextInt(); // 테스트케이스의 번호
			sc.nextLine(); // 개행문제 제거
			String targetStr = sc.nextLine(); // 찾을 문자열 => 배열로 받아줌
			String str = sc.nextLine(); // 대상 문자열
			int cnt = 0; // 동일한 문자열의 개수 카운트
			
			int idx = 0;
			
			// 찾을 문자열이 발견되지 않을 때까지 반복한다
			// idx에 str에 이전에 입력된 idx 인덱스부터 찾을 문자를 찾아서 해당 위치를 지속적으로 업데이트 해준다
			// 만약 찾지 못하면 indexOf 는 -1을 반환함
			while ((idx = str.indexOf(targetStr, idx)) != -1) {
                cnt++; // 찾을때마다 cnt가 증가하고
                idx += targetStr.length(); // idx값을 업데이트 해준다
            }
			
			System.out.printf("#%d %d\n", tNum, cnt);
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝
