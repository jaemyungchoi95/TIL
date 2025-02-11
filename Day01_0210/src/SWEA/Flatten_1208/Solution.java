package SWEA.Flatten_1208;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = sc.nextInt(); // 총 옮길 수 있는 제한 횟수
			int[] arr = new int[100]; // 길이가 100인 정수 배열 선언 (가로의 길이는 항상 100)

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 초기 최대/최소값 
			int max = arr[0];
			int min = arr[0];

			// 전체 덤프 횟수만큼 반복하면서
			for (int i = 0; i < n; i++) {
				int maxIdx = 0; // 최대값과 최소값을 담아줄 변수 선언
				int minIdx = 0;
				// 덤프 횟수마다 최대 최소값을 탐색해준다
				for (int j = 1; j < 100; j++) {
					// 최대값이 있는 인덱스를 탐색하고
					if (arr[j] > arr[maxIdx]) {
						// 최신화 해준다
						maxIdx = j;
					}
					// 최소값이 있는 인덱스도 마찬가지로 탐색해준다.
					if (arr[j] < arr[minIdx]) {
						minIdx = j;
					}
				}
				// 최대 최소값의 차이가 1 이라하면 다음 숫자로 넘어가고
				if (arr[maxIdx] - arr[minIdx] <= 1) {
					break;
				}
				// 그렇지 않다면 정렬된 숫자의 최대값은 -1, 최솟값은 +1을 해줌
				arr[maxIdx] -= 1;
				arr[minIdx] += 1;

				max = arr[maxIdx];
				min = arr[minIdx];
			}

			// 덤프횟수가 모두 끝나면 최대최소값을 모두 최소값으로 초기화해주고
			// 최종적으로 변경된 배열에서 다시 최소값과 최대값을 찾아준다.

			// 반복문이 끝나면 최대값과 최소값의 차를 출력한다.
			System.out.printf("#%d %d\n", test_case, max - min);

		}
	}
}