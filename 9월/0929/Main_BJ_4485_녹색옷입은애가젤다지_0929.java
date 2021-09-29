import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지_0929 {
	
	private static class Node implements Comparable<Node>{
		int r, c, w;
		
		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static int N;
	static ArrayList<Node> arr[];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			System.out.print("Problem " + idx + ": ");
			idx++;
			
			int map[][] = new int[N][N];
			int d[][] = new int[N][N];
			
			arr = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println(Arrays.toString(arr));
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(d[i], Integer.MAX_VALUE);
			}
			d[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int cr = node.r;
				int cc = node.c;
				int cw = node.w;
				
				for (int i = 0; i < 4; i++) {
					int nr = cr + dx[i];
					int nc = cc + dy[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(d[nr][nc] > cw + map[nr][nc]) {
						d[nr][nc] = cw + map[nr][nc];
						pq.add(new Node(nr, nc, cw + map[nr][nc]));
					}
					
				}
				
			}
			System.out.println(d[N - 1][N - 1]);
		}
	}

}
