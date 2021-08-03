//import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			int num = 1; // 출력할 숫자
			int x = 0; // x좌표
			int y = -1; // y좌표 - 처음에 1인 dir를 더하고 시작하기 때문에 -1로 설정
			int cnt = n; // 감소해야하는 수
							// n -> n-1 -> n-1 -> n-2 -> n-2 -> ...
							// 제일 처음을 제외하고는 2번씩 반복
			int dir = 1;

			while (num <= n * n) {
				// 좌우로 움직일 때 : x좌표 고정
					// 오른쪽으로 갈때 : dir = 1
					// 왼쪽으로 갈때 : dir = -1
				for (int i = 0; i < cnt; i++) {
					y += dir;
					arr[x][y] = num;
					num++;
				}

				cnt--; // 제일 처음을 제외하고는 두 번씩 반복되기 때문에 여기서 개수를 1번 감소시킴

				// 상하로 움직일 때 : ㅛ좌표 고정
					// 아래쪽으로 갈 때 : dir = 1
					// 위쪽으로 갈 때 : dir = -1
				for (int i = 0; i < cnt; i++) {
					x += dir;
					arr[x][y] = num;
					num++;
				}
				
				dir *= -1; // 방향 바꾸기
				
			} // while

			
			// 출력
			System.out.println("#" + t);
			for (int[] a : arr) {
				for (int tt : a) {
					System.out.print(tt + " ");
				}
				System.out.println();
			}

		} // testcase

	} // 메인

}