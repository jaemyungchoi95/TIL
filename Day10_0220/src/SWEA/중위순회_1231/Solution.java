package SWEA.중위순회_1231;

import java.util.Arrays;
import java.util.Scanner;

//1231. [S/W 문제해결 기본] 9일차 - 중위순회
public class Solution {
	static int N; // 정점의 수
	static String[][] tree; // 단어를 저장할 트리 문자배열
	static StringBuilder sb; // 단어를 순서대로 담아줄 문자열
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
        // 테스트케이스 10개가 주어진다
		for(int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt(); // 정점의 수를 입력받는다
			sc.nextLine(); // 개행문자 제거
			
			tree = new String[N+1][4]; // 단어를 저장할 트리 문자배열 초기화
			sb = new StringBuilder(); // 단어를 순서대로 담아줄 스트링빌더 초기화
			
			for (int i = 1; i <= N; i++) {
				String[] input = sc.nextLine().split(" ");
				
				tree[i][0] = input[0]; // 노드 번호를 담아준다
				tree[i][1] = input[1]; // 문자를 담아준다
				tree[i][2] = "0"; // 왼쪽 자식의 숫자를 0으로 초기화
				tree[i][3] = "0"; // 오른쪽 자식의 숫자를 0으로 초기화
				
				// 자식들을 담아줄 건데, 만약 입력이 없는데 담아주는 경우를 방지하기 위해 길이 조건을 추가해준다
				if(input.length > 2) tree[i][2] = input[2]; // 왼쪽자식을 담아준다
				if(input.length > 3) tree[i][3] = input[3]; // 오른쪽자식 오른쪽 자식을 담아준다
			}
			// 중위순회 함수를 호출
			inOrder(1);
			
			// 결과 출력
			System.out.printf("#%d %s\n", test_case, sb);

		} // 테스트케이스 끝
		sc.close();    
	} // main 끝
	
	// 중위 순회 함수
	public static void inOrder(int v) {
		// 만약 값이 0이면 함수 실행 X
		if (v == 0) return;
			inOrder(Integer.parseInt(tree[v][2])); // 왼쪽 자식노드로 다시 함수를 실행
			sb.append(tree[v][1]); // 왼쪽 자식이 없다면 자신의 알파벳을 추가
			inOrder(Integer.parseInt(tree[v][3])); // 오른쪽 자식이 있으면 다시 함수를 실행
	}
    
} // 클래스 끝