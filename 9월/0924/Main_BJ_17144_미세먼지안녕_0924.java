import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕_0924 {

	static int R, C, T, arr[][], cur[][];
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		cur = new int[R][C];
		int ac = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					ac = i;
				}
			}
		}

		while (T-- > 0) {
			dust();
			rotate(ac);

//			print();
		}

		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int x : arr[i]) {
				res += x;
			}
			// 공기청정기 위치 부분 더하기
			res += 2;
		}

		System.out.println(res);

	} // end main

	private static void dust() {
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(cur[i], 0);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] < 1) continue;
				
					int cnt = 0;
					int value = arr[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + dx[d];
						int nc = j + dy[d];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] == -1) 
							continue;
						
						cur[nr][nc] += value;
						cnt++;
					}
					arr[i][j] = arr[i][j] - value * cnt;
			}
		}
		
		// 이번 턴에 변경된 값 반영
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] != -1)	
					arr[i][j] += cur[i][j];
			}
		}
//		print();
	}


	private static void rotate(int ac) {
		// 위 (반시계)
		// 상 -> 하
		for (int i = ac - 3; i >= 0; i--) {
			arr[i + 1][0] = arr[i][0];
		}

		// 우 -> 좌
		for (int i = 1; i < C; i++) {
			arr[0][i-1] = arr[0][i];
		}

		// 하 -> 상
		for (int i = 1; i <= ac; i++) {
			arr[i - 1][C - 1] = arr[i][C - 1];
		}

		// 좌 -> 우
		for (int i = C - 2; i > 0; i--) {
			arr[ac-1][i+1] = arr[ac-1][i];
		}

		arr[ac-1][1] = 0;
//		print();

		// 아래 (시계)
		// 하 -> 상
		for (int i = ac+2; i < R; i++) {
			arr[i - 1][0] = arr[i][0];
		}

		// 우 -> 좌
		for (int i = 1; i < C; i++) {
			arr[R - 1][i - 1] = arr[R - 1][i];
		}

		// 상 -> 하
		for (int i = R - 2; i >= ac; i--) {
			arr[i + 1][C - 1] = arr[i][C - 1];
		}

		// 좌 -> 우
		for (int i = C - 2; i > 0; i--) {
			arr[ac][i + 1] = arr[ac][i];
		}
		arr[ac][1] = 0;
//		print();

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
} // end class
