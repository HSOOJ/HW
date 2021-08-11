import java.util.Scanner;

public class Main_BJ_16935_배열돌리기3{

	static int N, M, R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 배열의 크기
		M = sc.nextInt(); // 배열의 크기
		R = sc.nextInt(); // 수행해야하는 연산의 수

		int[][] arr = new int[N][M]; // 배열

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int t;
		while (R-- > 0) {
			C = sc.nextInt(); // 수행해야하는 연산
			switch (C) {
			case 1:
				case1(arr);
				break;
			case 2:
				case2(arr);
				break;
			case 3:
				arr = case3(arr);
				t = N;
				N = M;
				M = t; // 90도 회전시 배열의 행과 열을 바꾼 새로운 배열을 생성하기 때문에 M <-> N
				break;
			case 4:
				arr = case4(arr);
				t = N;
				N = M;
				M = t; // 90도 회전시 배열의 행과 열을 바꾼 새로운 배열을 생성하기 때문에 M <-> N
				break;
			case 5:
				arr = case5(arr);
				break;
			case 6:
				arr = case6(arr);
				break;
			}

		}
		print(arr);
		sc.close();
	} // main

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	} // print

	// 부분 배열 바꾸기 1 -> 4 -> 3 -> 2
	private static int[][] case6(int[][] arr) {
		int[][] res = new int[N][M];

		// 1 -> 4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				res[N / 2 + i][j] = arr[i][j];
			}
		}

		// 2 -> 1
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				res[i][j - M / 2] = arr[i][j];
			}
		}

		// 3 -> 2
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				res[i - N / 2][j] = arr[i][j];
			}
		}

		// 4 -> 3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				res[i][j + M / 2] = arr[i][j];
			}
		}

		return res;
	} // case6

	// 부분 배열 바꾸기 1 -> 2 -> 3 -> 4
	private static int[][] case5(int[][] arr) {
		int[][] res = new int[N][M];

		// 1 -> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				res[i][M / 2 + j] = arr[i][j];
			}
		}

		// 2 -> 3
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				res[N / 2 + i][j] = arr[i][j];
			}
		}
		
		// 3 -> 4
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				res[i][j - M / 2] = arr[i][j];
			}
		}
		
		// 4 -> 1
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				res[i - N / 2][j] = arr[i][j];
			}
		}
		return res;
	} //case 5

	// 왼쪽으로 90도 회전
	private static int[][] case4(int[][] arr) {
		int[][] res = new int[M][N]; // 행과 열의 크기가 다를 경우도 있기 때문에 새로운 배열 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res[M - 1 - j][i] = arr[i][j];
			}
		}
		return res;
	} //case 4

	// 오른쪽으로 90도 회전
	private static int[][] case3(int[][] arr) {
		int[][] res = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				System.out.println(i + ":" + j + "->" + j + "," + (N-1-i));
				res[j][N - 1 - i] = arr[i][j];
			}
		}
		return res;
	} // case3

	// 좌우 반전
	private static void case2(int[][] arr) {
		for (int i = 0; i < M / 2; i++) {
			for (int j = 0; j < N; j++) {
				int t = arr[j][i];
				arr[j][i] = arr[j][M - 1 - i];
				arr[j][M - 1 - i] = t;
			}
		}
	} // case2

	//상하 반전
	private static void case1(int[][] arr) {
		for (int i = 0; i < N / 2; i++) {
			int[] t = arr[i];
			arr[i] = arr[N - 1 - i];
			arr[N - 1 - i] = t;
		}
	} // case1

} // class
