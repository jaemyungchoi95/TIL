package SWEA.암호문3_1230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 이 문제의 테스트케이스는 10개로 정해져 있다
		for(int test_case = 1; test_case <= 10; test_case++) {
			sc.nextLine(); // 암호문의 개수 N
			ArrayList<String> originArr = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
			sc.nextLine(); // 명령어의 개수 M
			ArrayList<String> codeArr = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
			
			StringBuilder sb = new StringBuilder();
			
			int idx = 0;

			int iCnt = 0;
			int iN = 0;
			
			int dCnt = 0;
			int dN = 0;
			
			int aCnt = 0;
			
			String prev = "";
			for (int i = 0; i < codeArr.size(); i++) {
				if (iCnt == 0 && codeArr.get(i).equals("I")) {
					iCnt = 2;
					prev = "I";
					continue;
				}

				if (prev.equals("I") && iCnt == 2) {
					idx = Integer.parseInt(codeArr.get(i));
					iCnt--;
					continue;
				}
				
				if (prev.equals("I") && iCnt == 1) {
					iN = Integer.parseInt(codeArr.get(i));
					iCnt--;
					continue;
				}
				
				if (prev.equals("I") && iCnt == 0 && iN > 0) {
					iN--;
					originArr.add(idx++, codeArr.get(i));
					continue;
				}
				
				if (dCnt == 0 && codeArr.get(i).equals("D")) {
					dCnt = 2;
					prev = "D";
					continue;
				}
				
				if (prev.equals("D") && dCnt == 2) {
					idx = Integer.parseInt(codeArr.get(i));
					dCnt--;
					continue;
				}
				
				if (prev.equals("D") && dCnt == 1) {
					dN = Integer.parseInt(codeArr.get(i));
					dCnt--;
					continue;
				}
				
				if (prev.equals("D") && dCnt == 0 && dN > 0) {
					dN--;
					originArr.remove(idx);
					continue;
				}
				
				if (aCnt == 0 && codeArr.get(i).equals("A")) {
					aCnt = 1;
					prev = "A";
					continue;
				}
				
				if (prev.equals("A") && aCnt == 1) {
					aCnt--;
					continue;
				}
				
				if (prev.equals("A") && aCnt == 0) {
					originArr.add(codeArr.get(i));
					continue;
				}
				
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(originArr.get(i));
			}
			
			// 정답 출력
			System.out.printf("#%d%s\n", test_case, sb);
			
		} // 테스트케이스 끝
        sc.close();
	} // main 끝
    
} // 클래스 끝
