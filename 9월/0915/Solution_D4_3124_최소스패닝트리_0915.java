
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_0915 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;

	static int[] parents; // 부모 원소를 관리(트리처럼 사용)

	// 모든 원소를 자신의 대표자로 만듦
	private static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;

		}
	} // end make

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a]) // 자신이 대표자
			return a;
		return parents[a] = find(parents[a]); 
	} // end find

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) // 이미 같은 집합으로 합치지 않음
			return false;

		parents[bRoot] = aRoot;

		return true;

	} // end union

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(start, end, weight);

			}

			Arrays.sort(edgeList);

			make();

			int cnt = 0; // 간선의 수
			long result = 0; // 최소비용 누적값
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					if (++cnt == V - 1) // 신장 트리 완성
						break;
				}
			}

			System.out.println("#" + t + " " + result);
		}
	} // end main

}
