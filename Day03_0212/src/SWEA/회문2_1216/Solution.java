package SWEA.회문2_1216;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 해당 문제의 테스트케이스는 총 10개이다
		for(int test_case = 1; test_case <= 1; test_case++) {
		int tNum = sc.nextInt(); // 테스트케이스 번호
		sc.nextLine(); // 개행 문자 제거
		String[][] arr = new String[100][100]; // 글자판 2차원 배열
		
		for (int i = 0; i < 100; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < 100; j++) {
				arr[i][j] = Character.toString(temp.charAt(j));
			}
		}
		
		for(int i = 0; i < 100; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		
		// 정답 출력
//		System.out.printf("#%d %d", tNum, );
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝
