import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈_0915 {

	static class Cheese {
		int r, c;

		public Cheese(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int r, c, cnt = 0;
	static int[][] arr;
	static boolean[][] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				int t = Integer.parseInt(st.nextToken());
				arr[i][j] = t;
				if (t == 1)
					cnt++;
			}
		}

		int hour = 0;
		int res = 0;
		if (cnt == 1) {
			hour = 1;
			res = 1;
		} else {
			while (cnt != 0) {
				hour++;
				res = cnt;
				bfs();
			}
		}

		System.out.println(hour);
		System.out.println(res);

	}

	public static void bfs() {
		Queue<Cheese> cheese = new LinkedList<>();
		cheese.offer(new Cheese(0, 0));
		checked = new boolean[r][c];
		checked[0][0] = true;

		while (!cheese.isEmpty()) {
			Cheese t = cheese.poll();
			int x = t.r;
			int y = t.c;

			for (int i = 0; i <= 3; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];

				if (nr < 0 || nr >= r || nc < 0 || nc >= c || checked[nr][nc])
					continue;

				if (arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					cnt--;
				} else if (arr[nr][nc] == 0) {
					cheese.offer(new Cheese(nr, nc));
				}
				checked[nr][nc] = true;
			}
		}
	}
}
