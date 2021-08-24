import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 다익스트라
public class Main_BJ_1753_최단경로_0824_list {
	
	static class Node {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
	}
	
	static int V, E, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(br.readLine()); // 시작 점

		List<Node>[] adjList = new ArrayList[V+1]; // 인접 리스트
		int[] d = new int[V+1]; // 거리 배열
		boolean visited[] = new boolean[V + 1]; // 방문 여부 체크
		
		// 노드 배열 정점 개수만큼 생성
		for (int i = 0; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, w));

		} // end for

		
		// 거리 배열 전체 최대값으로 설정
		Arrays.fill(d, Integer.MAX_VALUE);

		// 시작점 자신은 0으로
		d[K] = 0;

		int min = 0; // 가장 작은 값
		int current = 0; // 가장 작은 값의 위치
		
		// 모든 정점 다 돌기
		for (int i = 1; i <= V; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j <= V; j++) {
				if (!visited[j] && d[j] < min) { // 방문한적 없고 현재 가중치가 최소값보다 작을 때
					min = d[j]; // 최소값 저장
					current = j; // 현재 위치 변경
				}
			}

			visited[current] = true; // 방문 표시
			
			// 연결이 없으면 종료
			if (current == 0) 
				break;
			
			// 갈 수 있는 경로 업데이트
			for(Node next : adjList[current]) {
				// 방문한적 없고 / 새로운 노드에서 다음 노드로 가는 가중치가 더 작으면 그 값으로 갱신 
				if(!visited[next.vertex] && d[current] + next.weight < d[next.vertex]) {
					d[next.vertex] = d[current] + next.weight; 
				}
			}

		} // end for i
		
		// 출력
		for(int i = 1; i <= V; i++) {
			if(d[i] == Integer.MAX_VALUE)
				System.out.println("INF"); // 연결된 게 없으면 초기화해놨던 maxvalue이기 때문에 inf로 출력
			else System.out.println(d[i]);
		}
		

	} // end main

} // end class
