import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토_0924 {

	// 익은 토마토 좌표 지정
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Loc [r=" + r + ", c=" + c + "]";
		}

	}

	static int M, N, arr[][], res = 0,
			  dx[] = { 0, 0, -1, 1 },
			  dy[] = { -1, 1, 0, 0 };
	static Queue<Loc> tomato;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로 칸
		N = Integer.parseInt(st.nextToken()); // 세로 칸 

		arr = new int[N][M];
		tomato = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토 좌표 enqueue
				if (arr[i][j] == 1)
					tomato.add(new Loc(i, j)); 
			}
		}

		// 처음부터 모든 토마토가 익어있는 상태
		if (tomato.size() == M * N)
			res = 0;
		else {

			bfs();

			print: for (int i = 0; i < N; i++) {
				for (int x : arr[i]) {
					// 토마토가 모두 익지 못하는 상황
					if (x == 0) {
						res = -1;
						break print; // 마지막 줄이 아닌 부분에 0이 있으면 이후 탐색 할 필요 없음
					// 토마토 익은 날짜 찾기
					} else
						res = Math.max(res, x);
				}
			}
		}

		// 토마토가 모두 익어있거나 모두 익지 못하는 상황
		if (res == -1 || res == 0)
			System.out.println(res);
		// 토마토 익는 날짜는 1부터 시작했기 때문에 -1 해서 출력
		else
			System.out.println(res - 1);

	}

	private static void bfs() {
		while (!tomato.isEmpty()) {
			Loc curTomato = tomato.poll();
			int r = curTomato.r;
			int c = curTomato.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];

				// 배열 범위 유효성 체크
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				// 익은 토마토 주변에 안익은 토마토
				// 익은 토마토 숫자에 1을 더해서 날짜 지정
				// 익은 토마토 큐에 추가
				if (arr[nr][nc] == 0) {
					arr[nr][nc] = arr[r][c] + 1;
					tomato.offer(new Loc(nr, nc));
				}
			}
		}

	}

}
