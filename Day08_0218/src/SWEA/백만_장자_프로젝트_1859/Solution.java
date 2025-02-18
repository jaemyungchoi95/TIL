package SWEA.백만_장자_프로젝트_1859;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스의 수
		
		// 테스트케이스 만큼 반복한다
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int cnt = 0; // 자신보다 높은 값을 담아줄 변수
			int max = 0; // 최대값을 담아줄 변수
			int sum = 0; // 얻는 이익을 담아주는 변수
			
			int[] arr = new int[N]; // 미리 예측하는 가격을 담아주는 변수
			int[] ansArr = new int[N]; // 미리 예측하는 가격을 담아주는 변수
			
			// 예측가를 배열에 담아주면서 max값 업데이트
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max) {
					max = arr[i];
				}
			}
			
			// 1 ~ N까지 돌면서
			for (int i = 0; i < N; i++) {
				System.out.printf("i : %d\n", i);
				for (int j = i+1; j < N; j++) {
					if (i != j) {
						System.out.printf("j : %d\n", j);
						// j가 i보다 크면서 max와 같으면 
						if (arr[i] < arr[j]) {
							if (arr[j] >= max) {
								sum += arr[j] - arr[i];
							} else {
								sum += max - arr[i];
							}
							continue;
							// j가 i보다 큰 수를 만나면 그 값을 최대값으로 담고 반복을 멈춰준다.
						} // if
//						System.out.printf("sum : %d\n", sum);
					}
				} // for j
				
			} // for i
			
//			System.out.printf("#%d %d\n", test_case, sum);
			System.out.println();
		} // 테스트케이스 끝
		
	} // main 끝
	
} // 클래스 끝


/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2

 * */