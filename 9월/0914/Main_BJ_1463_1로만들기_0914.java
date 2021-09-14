import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1463_1로만들기_0914 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[1000001];
		
		arr[2] = 1;
		arr[3] = 1;			
		
		for (int i = 4; i <= N; i++) {
			int tmp1 = 0, tmp2 = 0, tmp3 = 0;
			int tmp = Integer.MAX_VALUE;
			if(i % 3 == 0) {
				tmp3 = arr[i/3] + 1;
				tmp = Math.min(tmp, tmp3);
			}
			if(i % 2 == 0) {
				tmp2 = arr[i/2] + 1; 
				tmp = Math.min(tmp, tmp2);
			}
			
			tmp1 = arr[i-1] + 1;
			
			arr[i] = Math.min(tmp, tmp1);
		}
		System.out.println(arr[N]);
	}

}
