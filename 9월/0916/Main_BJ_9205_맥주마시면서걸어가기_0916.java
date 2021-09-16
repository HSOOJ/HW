import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_9205_맥주마시면서걸어가기_0916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();

			int arr[][] = new int[N + 2][2];
			int arr2[][] = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				Arrays.fill(arr2[i], 987654321);
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j) continue;

					int dis = Math.abs(arr[j][0] - arr[i][0]) + Math.abs(arr[j][1] - arr[i][1]);
					if (dis <= 1000)
						arr2[i][j] = 1;
				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (arr2[i][j] > arr2[i][k] + arr2[k][j])
							arr2[i][j] = arr2[i][k] + arr2[k][j];
					}
				}
			}

			if (arr2[0][N + 1] > 0 && arr2[0][N + 1] < 987654321)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
