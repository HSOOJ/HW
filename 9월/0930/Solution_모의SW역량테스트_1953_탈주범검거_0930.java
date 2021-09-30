import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_1953_탈주범검거_0930 {

	static int N, M, R, C, L, map[][], res = 0;
	static boolean visited[][];
	static String[] type = {
			null,
			"0312", // 1: 상하좌우
			"03", // 2:상하
			"12", // 3:좌우
			"02", // 4:상우
			"32", // 5:하우
			"31", // 6:하좌
			"01" // 7:상좌
	};
	
	static int[] dx = { -1, 0, 0, 1 };// 상 0, 좌 1 , 우 2 ,하 3
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); // 행크기
			M = Integer.parseInt(st.nextToken()); // 열크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 행
			C = Integer.parseInt(st.nextToken()); // 맨홀 열
			L = Integer.parseInt(st.nextToken()); // 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			sb.append("#" + t + " " + res + "\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void bfs() {
		int time = 1; // 맨홀에 처음 있는 시간도 1로 처리해야하므로 time = 1
		res = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { R, C });
		visited[R][C] = true;
		res++;
		
		while (time++ < L) { // 경과 시간동안 반복
			int size = queue.size();
			
			// 1시간당 움직인 곳 구해야함
			while (size-- > 0) {
				int current[] = queue.poll();
				int r = current[0];
				int c = current[1];
				
				// 해당 위치에 있는 파이프 모양 구분
				String info = type[map[r][c]];

				// 파이프 모양에 따라서 반복문 설정
				for (int d = 0; d < info.length(); d++) {
					int dir = info.charAt(d) - '0';
					int nr = r + dx[dir];
					int nc = c + dy[dir];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M // 배열 범위를 벗어나지 않고
							&& map[nr][nc] != 0 // 터널이 있고
							&& type[map[nr][nc]].contains(Integer.toString(3 - dir)) // 다음 칸의 파이프가 지금 있는 칸과 연결되어 있는 경우
							&& !visited[nr][nc]) { // 방문하지 않은 경우에

						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
						res++;
					}
				}
			}
		}
	}
}