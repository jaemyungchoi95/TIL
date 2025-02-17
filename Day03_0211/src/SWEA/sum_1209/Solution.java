package SWEA.sum_1209;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 이 문제의 테스트케이스는 총 10개이다
		for(int test_case = 1; test_case <= 10; test_case++) {
			int tNum = sc.nextInt();
			int[][] arr = new int[100][100]; // 크기가 100*100인 배열 선언
			int sumX1 = 0; // 대각선 좌상 -> 우하
			int sumX2 = 0; // 대각선 우상 -> 좌하
			int[] sumRowArr = new int[100]; // 가로 합 배열
			int[] sumColArr = new int[100]; // 세로 합 배열
			
			// for문을 통하여 배열에 값을 담아준다
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// for문을 이용하여 대각선 탐색
			for (int i = 0; i < 100; i++) {
				sumX1 += arr[i][i];
				sumX2 += arr[i][99-i];
				int tempRowSum = 0;
				int tempColSum = 0;
				for (int j = 0; j < 100; j++) {
					tempRowSum += arr[i][j];
					tempColSum += arr[j][i];
				}
				sumRowArr[i] = tempRowSum;
				sumColArr[i] = tempColSum;
			}
			
			Arrays.sort(sumRowArr);
			Arrays.sort(sumColArr);
			
			System.out.printf("#%d %d\n", tNum, Math.max(Math.max(sumX1, sumX2), Math.max(sumRowArr[99], sumColArr[99])));
			
		} // 테스트 케이스 끝
		
	} // main 끝
	
} // 클래스 끝