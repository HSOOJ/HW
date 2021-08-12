import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_3040_백설공주와일곱난쟁이_0812 {

	static int[] input;
	static int[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		res = new int[7];
		for(int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0, 0);
	}
	
	private static void permutation(int cnt, int start) {
		if(cnt == 7) {
			if (Arrays.stream(res).sum() == 100) {
				for(int x : res) {
					System.out.println(x);
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			res[cnt] = input[i];
			permutation(cnt+1, i+1);
		}
	}
	
	

}
