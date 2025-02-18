package REMIND.IM;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int n,AnswerN;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스의 수

        // 테스트케이스 진행
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // N을 입력받는다
            int[][] arr = new int[N][N]; // N*N 배열 생성

            int maxCnt = Integer.MIN_VALUE; // 이동거리의 최대값을 담아줄 변수 선언

            // 배열에 높이를 입력받는다
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 상 우 하 좌 탐색
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            // 탐색현황을 담아줄 q 선언
            Queue<int[]> q = new LinkedList<>();

            // 전체를 탐색하면서 4방 탐색을 진행해 줄 것
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <N; j++) {
                    int cnt = 1; // 유효 탐색 수를 카운트해준다
                    int location = arr[i][j]; // 현위치의 높이값을 담아준다
                    int min = Integer.MAX_VALUE; // 4방향 중 최저 높이를 담아준다
                    q.add(new int[] {i, j}); // 탐색을 위한 i, j를 넣어준다
                    int x = 0;
                    int y = 0;

                    while (!q.isEmpty()) {
                        boolean[][] vis = new boolean[N][N]; // 방문여부를 담아줄 배열 선언
                        int[] tmp = q.poll();
                        int curX = tmp[0];
                        int curY = tmp[1];
                        vis[curX][curY] = true;

                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];
                            // 범위를 벗어나지 않을때만 탐색
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                // 탐색하다가  최소값보다 작은 값을 발견하면 min을 업데이트하고 좌표를 업데이트 해줌
                                if (arr[nx][ny] < min) {
                                    min = arr[nx][ny];
                                    x = nx;
                                    y = ny;
//                                    System.out.printf("min : %d\n", min);
                                }
                            }
                        } // for d

                        // 만약 min < location 이면
                        if (min < location && !vis[x][y]) {
                            // 큐에 최소값의 좌표를 넣어주고
                            q.add(new int[] {x, y});
                            cnt++; // cnt를 더한다
//                            System.out.printf("cnt : %d\n", cnt);
//                            System.out.printf("x, y : %s %s\n", x, y);
                        }

                    } // while 끝

                    // while문 종료 후 만약 현재의 cnt 값이 maxCnt보다 크다면 
                    if (cnt > maxCnt) {
                        maxCnt = cnt; // maxCnt 업데이트
                    }
//                    System.out.printf("maxCnt : %d\n", maxCnt);

                } // for j

            } // for i

            AnswerN = maxCnt;

            System.out.println("#" + test_case+" "+AnswerN);

        } // 테스트케이스 끝

    } // main 끝

} // 클래스 끝

/*
3
5
19 57 74 73 94
26 27 32 98 61
40 88 49 38 25
21 66 53 95 46
80 23 58 39 89
7
40 49 56 83 84 31 11
42 95 12 16 21 19 26
98 93 29 68 10 92 82
23 13 24 58 35 25 47
17 66 39 67 70 14 87
22 34 46 94 69 96 89
62 88 50 51 61 71 86
9
90 57 65 18 25 93 64 11 54
95 19 80 37 63 44 15 14 10
89 59 46 70 38 36 21 51 97
53 47 60 88 40 48 79 56 55
83 13 27 86 45 71 75 28 84
30 20 29 35 99 98 61 94 23
85 42 43 22 16 77 31 78 34
74 26 73 92 50 72 87 49 32
68 24 91 12 17 82 69 67 81

*/