package java.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {

	static boolean arr[][];
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new boolean[N][M];

		for(int i=0; i<N; i++){
			String input = br.readLine();
			for(int j=0; j<M; j++){
				if(input.charAt(j) == 'W'){
					arr[i][j] = true;
				}else{
					arr[i][j] = false;
				}
			}
		}

		for(int i=0; i<N-7; i++){
			for(int j=0; j<M-7; j++){
				find(i, j);
			}
		}

		System.out.println(min);
	}

	private static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int cnt = 0;

		boolean first = arr[x][y];


	}

}
