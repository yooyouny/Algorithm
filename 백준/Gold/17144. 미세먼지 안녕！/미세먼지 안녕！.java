import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] di = {0, 0, -1, 1};
	static int[] dj = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int [][] map = new int[R][C];
		int air = 0; //공기청정기 좌표 
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) air = i; 
			}
		}
		air--; 
		
		for(int t = 0; t<T; t++) {
			int [][] toom = new int[R][C];
			for(int i=0; i<R; i++) { //미세먼지 확산 
				for(int j=0; j<C; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) { //미세먼지 값이 있는 곳 
					int cnt = 0; //확산된 방향 수 
					for(int k=0; k<di.length; k++) {
						int ny = i+di[k];
						int nx = j+dj[k];
						if(ny>=0 && nx>=0 && ny<R && nx<C && map[ny][nx] != -1) {
							cnt++;
							toom[ny][nx] += map[i][j] / 5;
						}
					}
					map[i][j] -= (map[i][j]/5) * cnt; //남은 미세먼지 양   
					}
				}
			}			
		//합산: 계산된 이동 먼지 양 합 계산 
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] += toom[r][c]; 
			}
		}
		
		//순환: 삭제되는 것 부터 제거해야 다른 항이 소실되지 않음
		for(int i=air-1; i>=1; i--) map[i][0] = map[i-1][0]; 
		for(int i=0; i<C-1; i++) map[0][i] = map[0][i+1]; 
		for(int i=0; i<air; i++) map[i][C-1] = map[i+1][C-1]; 
		for(int i=C-1; i>=1; i--) map[air][i] = map[air][i-1]; 
		map[air][1] = 0; // -1을 0으로 
		//아래
		for(int i=air+2; i<R-1; i++) map[i][0] = map[i+1][0]; 
		for(int i=0; i<C-1; i++) map[R-1][i] = map[R-1][i+1]; 
		for(int i=R-1; i>air+1; i--) map[i][C-1] = map[i-1][C-1]; 
		for(int i=C-1; i>=1; i--) map[air+1][i] = map[air+1][i-1]; 
		map[air+1][1] = 0; // -1을 0으로 
	}
		
		int sum = 2; //공기청정기 2대 -1
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) 
				sum += map[i][j];
		}
		System.out.println(sum);
	}	
}
