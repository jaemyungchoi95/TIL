package REMIND.A;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스의 수

    // 테스트케이스만큼 반복
    for (int test_case = 1; test_case <= T; test_case++) {
        int N = sc.nextInt(); // 화분의 개수
        int P = sc.nextInt(); // 중복으로 주면 덜자라는 가중치
        int stat = 0;
        int total = 0;
        
        int[] arrFst = new int[N]; // 첫 비료의 성장높이
        int[] arrSec = new int[N]; // 두번째 비료의 성장높이
        int[] answer = new int[N]; // 정답을 담아줄 배열
        
        // 비료별 화분 성장높이를 담아준다
        for (int i = 0; i < 4; i++) {
            arrFst[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            arrSec[i] = sc.nextInt();
        }
        
        // 화분들을 순회해주면서
        for (int i = 1; i < N; i++) {
            if (answer[i-1] == 0 && answer[i] == 0) {
                // 만약 첫 비료의 첫값과 두번째 비료의 두번째값의 합이 더 크면 그 값을 담아주고
                if (arrFst[i-1] + arrSec[i] > arrFst[i] + arrSec[i-1]) {
                    answer[i-1] = arrFst[i-1];
                    answer[i] = arrSec[i];
                    stat = 2; // 마지막 비료의 상태 변경
                    // 그렇지 않으면  arrSec의 첫번째 값을 담아준다
                } else {
                    answer[i-1] = arrSec[i-1];
                    answer[i] = arrFst[i];
                    stat = 1;
                }
                // 그런상황이 아니라면
            } else {
                // 직전의 화분의 마지막이 1번으로 끝났으면
                if (stat == 1) {
                    // 1번 비료를 주었을 때  p만큼 감소
                    arrFst[i] -= P;
                    // 만약 첫 비료의 첫값과 두번째 비료의 두번째값의 합이 더 크면 그 값을 담아주고
                    if (arrFst[i-1] + arrSec[i] > arrFst[i] + arrSec[i-1]) {
                        answer[i-1] = arrFst[i-1];
                        answer[i] = arrSec[i];
                        stat = 2; // 마지막 비료의 상태 변경
                        // 그렇지 않으면  arrSec의 첫번째 값을 담아준다
                    } else {
                        answer[i-1] = arrSec[i-1];
                        answer[i] = arrFst[i];
                        stat = 1;
                    }
                    
                } else if (stat == 2) {
                    // 2번 비료를 주었을 때 p만큼 감소
                    arrSec[i] -= P;
                    
                    // 만약 첫 비료의 첫값과 두번째 비료의 두번째값의 합이 더 크면 그 값을 담아주고
                    if (arrFst[i-1] + arrSec[i] > arrFst[i] + arrSec[i-1]) {
                        answer[i-1] = arrFst[i-1];
                        answer[i] = arrSec[i];
                        stat = 2; // 마지막 비료의 상태 변경
                        // 그렇지 않으면  arrSec의 첫번째 값을 담아준다
                    } else {
                        answer[i-1] = arrSec[i-1];
                        answer[i] = arrFst[i];
                        stat = 1;
                    }
                }
                
            }
        }
        
        for (int i : answer) {
            total += i;
        }
        
        // 정답 출력
        System.out.printf("#%d %d\n", test_case, total);
        
    } // 테스트케이스 끝
    
} // main 끝
} // 클래스 끝

/*
3
4 2
4 2 6 4
5 6 4 1
4 1
1 2 3 4
4 3 2 1
6 2
5 5 5 5 5 5
6 6 6 6 6 6

#1 18
#2 12
#3 33

 */