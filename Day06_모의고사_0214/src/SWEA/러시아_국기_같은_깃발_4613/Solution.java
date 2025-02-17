package SWEA.러시아_국기_같은_깃발_4613;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 행의 길이
			int M = sc.nextInt(); // 열의 길이
			sc.nextLine(); // 개행문자 제거
			int sum = 0; // 최소 수의 합계를 담아줄 변수
			
			String prevColor = ""; // 직전에 무슨 색을 담았는지 확인
			// W가 한줄이상 채워져야 함
			// W 충족 후 B 가 한줄 이상 채워져야 함
			// B 충족 후 R로 변경
//			System.out.printf("처음 prevColor : %s----------------------------\n", prevColor);
			
			// 초기 국기의 형태를 담아준다
			for (int i = 1; i <= N; i++) {
				String[] tempArr = sc.nextLine().split(""); // 한줄별로 문자열을 임시배열로 받아주고
				int wCnt = 0; // W의 개수 카운트
				int bCnt = 0; // B의 개수 카운트
				int rCnt = 0; // R의 개수 카운트
				
				// tempArr을 돌면서 각 숫자를 카운트 해준다
				for (int j = 0; j < M; j++) {
					if (tempArr[j].equals("W")) {
						wCnt++;
					} else if (tempArr[j].equals("B")) {
						bCnt++;
					} else if (tempArr[j].equals("R")) {
						rCnt++;
					}
				}
//				// 줄별로 카운트 된 현황 찍어보기
//				System.out.printf("i : %d W : %d B : %d R : %d\n", i, wCnt, bCnt, rCnt);
				
				// 만약 이전 컬러가 그냥 공백이면
				if (prevColor == "") {
					sum += bCnt + rCnt; // 최솟값에 B와 R의 갯수의 합을 담아준다
					prevColor = "W";
				}
				
				// 이전 컬러가 W라면 W나 B를 담아줘야 하는데
				else if (prevColor == "W") {
					// r + b의 수가 더 크거나 같으면 prevColor는 그대로 W
					if (rCnt + bCnt < rCnt + wCnt) {
						sum += rCnt + bCnt; // sum에는 R과 B를 더한 값을 누적해준다
						// 만약 반대가 되면 B로 바꿔준다
					} else if (rCnt + bCnt > rCnt + wCnt) {
						sum += rCnt + wCnt; // sum에 R과 W를 더한 값을 누적해주고
						prevColor = "B"; // 이전 컬러를 B로 바꿔준다
						// 값이 같다면 WB라는 prev로 저장
					} else if (rCnt + bCnt == rCnt + wCnt) {
						sum += rCnt + bCnt; // sum에는 R과 B를 더한 값을 누적해준다
						prevColor = "WB";
					}
				}
				
				// WB 일때는 상황을 잘 따져봐야 한다.
				else if (prevColor == "WB") {
					// 만약 WB 상태에서 i가 N-1가 되면 B로 가야한다
					// 그래야 다음이 B로 바뀌고 그다음이 R이 될 수 있기 때문
					if (i == N-1 ) {
						sum += wCnt + rCnt;
						prevColor = "B";
//						if (wCnt + rCnt > bCnt + rCnt) {
//							sum += wCnt + rCnt;
//							prevColor = "B";
//						} else {
//							sum += bCnt + rCnt;
//							prevColor = "R";
//						}
						
						// i가 N-2까지 안왔을 때는
					} else {
						// r + b의 수가 더 크거나 같으면 prevColor는 그대로 W
						if (rCnt + bCnt < rCnt + wCnt) {
							sum += rCnt + bCnt; // sum에는 R과 B를 더한 값을 누적해준다
							// 만약 반대가 되면 B로 바꿔준다
						} else if (rCnt + bCnt >= rCnt + wCnt) {
							sum += rCnt + bCnt; // sum에 R과 W를 더한 값을 누적해주고
							prevColor = "B"; // 이전 컬러를 B로 바꿔준다
							// 값이 같다면 WB라는 prev로 저장
						} else if (rCnt + bCnt == rCnt + wCnt) {
							sum += rCnt + bCnt; // sum에는 R과 B를 더한 값을 누적해준다
						}
					}
				}
				// 이전 컬러가 B라면 R을 담아주는 선택지밖에 없다
				else if (prevColor == "B") {
					sum += wCnt + bCnt;
					prevColor = "R";
				}
				
				else if (prevColor == "R") {
					sum += wCnt + bCnt;
				}
				
//				System.out.println();
//				System.out.printf("i : %d\n", i);
//				System.out.printf("prevColor의 현황 : %s\n", prevColor);
//				System.out.printf("sum의 현황 : %d\n", sum);
			}
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, sum);
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝
