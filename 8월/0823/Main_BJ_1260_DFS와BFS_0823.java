import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS_0823 {

	static int N, M ,V;
	static boolean [][] adjMatrix; 
//	static boolean[] visited;
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
			
		}
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs();
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		
		System.out.print(current + " ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adjMatrix[current][i])
				dfs(i, visited);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean []visited = new boolean[N+1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			 Integer p = queue.poll();
			
			System.out.print(p + " ");
			
			for(int i = 1; i < N+1; i++) {
				if(!visited[i] && adjMatrix[p][i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}