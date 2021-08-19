import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳_0819 {

	static int R, C, res = 0;
	static char map[][]; // 보드
	static int dx[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dy[] = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		// 방문한 알파벳 저장
		ArrayList<Character> list = new ArrayList<>();

		// 데이터 입력
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 말 움직이기
		route(0, 0, 1, list);

		// 결과 출력
		System.out.println(res);

	}

	private static void route(int r, int c, int cnt, ArrayList<Character> list) {
		// 현재 위치 알파벳
		char cur = map[r][c];

		// 방문했으면
		if (!list.contains(cur)) {
			list.add(cur); // 리스트에 알파벳 추가하기

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];

				// 배열 범위 검사
				if (0 <= nr && nr < R && 0 <= nc && nc < C)
					// 재귀
					route(nr, nc, cnt + 1, list);
			}

			// 최대로 움직인 칸
			res = Math.max(res, cnt);

		} else
			return;

		// 되돌아오면 리스트에서 제거
		list.remove(list.size() - 1);
	}
}