import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2239_스도쿠_1006 {

	static int arr[][];
	static boolean row[][], col[][], square[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];
		row = new boolean[10][10];
		col = new boolean[10][10];
		square = new boolean[10][10];

		for (int i = 0; i < 9; i++) {
			String st = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = st.charAt(j) - '0';
				row[i][arr[i][j]] = true;
				col[j][arr[i][j]] = true;
				square[(i / 3) * 3 + j / 3][arr[i][j]] = true;
			}
		}

		sdoku(0);

	}

	private static void sdoku(int cnt) {
		// 끝까지 탐색 완료
		if (cnt == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			
			System.exit(0);
			return;
		}

		int r = cnt / 9;
		int c = cnt % 9;

		// 현재 빈칸이 아니면 다음으로
		if (arr[r][c] != 0) {
			sdoku(cnt + 1);
			return;
		}

		// 탐색
		for (int i = 1; i <= 9; i++) {
			if (row[r][i] || col[c][i] || square[(r / 3) * 3 + c / 3][i])
				continue;

			row[r][i] = true;
			col[c][i] = true;
			square[(r / 3) * 3 + c / 3][i] = true;
			arr[r][c] = i;

			sdoku(cnt + 1);

			arr[r][c] = 0;
			row[r][i] = false;
			col[c][i] = false;
			square[(r / 3) * 3 + c / 3][i] = false;

		}
	}

}
