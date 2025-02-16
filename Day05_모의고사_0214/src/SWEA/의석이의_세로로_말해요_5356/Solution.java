package SWEA.의석이의_세로로_말해요_5356;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); // 테스트케이스의 수
		sc.nextLine(); // 개행문자 제거
		for(int test_case = 1; test_case <= T; test_case++) {
			String[][] arr = new String[5][]; // 5줄이고, 1줄에 최대 15개 이상인 문자열이 주어짐
			int maxLength = -1;
			StringBuilder sb = new StringBuilder();
			
			// 5개의 문자열을 입력받는다
			for (int i = 0; i < 5; i++) {
				arr[i] = sc.nextLine().split("");
				// 그리고 배열의 최대 길이만큼 돌아준다
				if (arr[i].length > maxLength)
					maxLength = arr[i].length;
			}
			
			// 길이가 작은 문자는 재편해준다.
			for (int i = 0; i < 5; i++) {
				// 만약 2차원배열의 길이가 최대 길이보다 작은 배열이면
				if (arr[i].length < maxLength) {
					// 임시배열에 원 배열을 복사해주면서 크기는 최대크기로 초기화 해준다
					String[] tempArr = Arrays.copyOf(arr[i], maxLength);
					// 이후 i번째 1차원배열은 최대 크기를 가진 배열로 다시 초기화 해준다
					arr[i] = new String[maxLength];
					
					// 최대길이만큼 반복문을 돌면서
					for (int j = 0; j < maxLength; j++) {
						// 만약 임시배열의 값이 null이 아니면 다시 값을 넣어주고
						if (tempArr[j] != null) {
							arr[i][j] = tempArr[j];							
							// null 이라면 공백을 넣어준다
						} else {
							arr[i][j] = "";
						}
					}
				}
			}
			
			// 2차원 배열의 최대 길이만큼 반복을 돌아주면서
			for (int j = 0; j < maxLength; j++) {
				for (int i = 0; i < 5; i++) {
					sb.append(arr[i][j]);
				}
			}
			
			// 정답 출력
			System.out.printf("#%d %s\n", test_case, sb);
			
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝

