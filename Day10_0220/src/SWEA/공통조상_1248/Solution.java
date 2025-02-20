package SWEA.공통조상_1248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//1248. [S/W 문제해결 응용] 3일차 - 공통조상
public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수
			int fNode = sc.nextInt(); // 조상을 찾는 첫번째 수
			int sNode = sc.nextInt(); // 조상을 찾는 두번째 수
			
			
			List<Integer> inputList = new ArrayList<>(); // 노드와 간선을 담아줄 배열 선언
			ArrayList<Integer> fArr = new ArrayList<>(); // 첫번째 자식들의 부모를 담아줄 리스트
			ArrayList<Integer> sArr = new ArrayList<>(); // 두번째 자식들의 부모를 담아줄 리스트 
			
			// 노드별 간선을 입력받는다
			for (int i = 0; i < E*2; i++) {
			    inputList.add(sc.nextInt());
			}
			
			int current = fNode;
            while (current != 1) { // 루트 노드(1)에 도달할 때까지
                for (int i = inputList.size() - 1; i > 0; i -= 2) {
                    if (inputList.get(i) == current) { // 자식 노드가 현재 노드인 경우
                        current = inputList.get(i - 1); // 부모를 찾음
                        fArr.add(current);
                        break;
                    }
                }
            }
			
            // 두 번째 노드의 부모 찾기
            current = sNode;
            while (current != 1) { // 루트 노드(1)에 도달할 때까지
                for (int i = inputList.size() - 1; i > 0; i -= 2) {
                    if (inputList.get(i) == current) { // 자식 노드가 현재 노드인 경우
                        current = inputList.get(i - 1); // 부모를 찾음
                        sArr.add(current);
                        break;
                    }
                }
            }
            
			System.out.println(Arrays.toString(fArr.toArray()));
			System.out.println(Arrays.toString(sArr.toArray()));
			System.out.println();
//			int ans = 0;
//			
//			for (int i = 0; i < fArr.size(); i++) {
//				if (ans > 0) break;
//				for (int j = 0; j < sArr.size(); j++) {
//					if (ans > 0) break;
//					if (fArr.get(i) == sArr.get(j)) {
//						ans = fArr.get(i);
//					}
//				}
//			}
			
			// 정답 출력
//			System.out.printf("#%d %d\n", test_case, ans);
			
		} // 테스트케이스 끝
        
	} // main 끝
    
} // 클래스 끝

/*
1
13 12 8 13
1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13

#1 3 8
 * */
