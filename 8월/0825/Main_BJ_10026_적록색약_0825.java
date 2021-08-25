import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10026_적록색약_0825 {

	static char [][] arr, arr2;
	static boolean [][] visited;
	static int cnt = 0, N;
	
	// 4방향 탐색용 배열
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 그리드 크기
		
		arr = new char[N][N]; // 적록색약이 아닌 사람이 봤을 때 그리드
		arr2 = new char[N][N]; // 적록색약인 사람이 봤을 때 그리드
		
		// 데이터입력
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				char c = str.charAt(j);
				arr[i][j] = str.charAt(j);
				if(c == 'R') // 빨간색이면 초록색으로 넣기
					arr2[i][j] = 'G';
				
				else
					arr2[i][j] = c;
			}
		}
		
		// 방문했는지 체크하는 배열
		visited = new boolean[N][N];

		// 다른 색을 가진 구역 개수 체크하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) { // 방문하지 않았을 때
					visited[i][j] = true; // 방문 체크하고
					dfs(i, j, arr); // dfs 호출(arr배열을 파라미터로)
					cnt++; // dfs 반환된다는 것은 다른 색을 만났다는 의미이기 때문에 +1
				}
			}
		}
		
		System.out.print(cnt + " "); // 적록색약이 아닌 사람이 봤을 때 구역 출력
		
		// 재사용을 위한 초기화
		cnt = 0;
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j, arr2); // 메서드 재사용을 위해 arr2배열을 파라미터로
					cnt++;
				}
			}
		}
		
		System.out.println(cnt); // 적록색약인 사람이 봤을 때 구역 출력
		
	} // end main

	// 구역 찾기
	private static void dfs(int x, int y, char[][] arr) {
		
		char c = arr[x][y]; // 현재 위치의 색
		
		// 상하좌우 탐색
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 배열을 벗어나지 않고, 방문한 적이 없고, 현재 위치의 색이랑 같을 때
			if(0 <= nx && nx < N && 0 <= ny & ny < N && !visited[nx][ny] && arr[nx][ny] == c) {
				visited[nx][ny] = true;
				dfs(nx, ny, arr);
			}
		}
	} // end dfs
} // end class


/*
 *	dfs 한번으로 다 해결하려고 하지말고 기능별로 나눠서 생각하기
 */