import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int R = in.nextInt();
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		map[i][j] = in.nextInt();
        	}
        }
    	
        for(int t=0; t<R; t++) {
        	int a = 0, b = 0;
        	int n = N;
        	int m = M;
        	int dept = 0;
        	if(n>=m) {
        		dept = m / 2;
        	}else {
        		dept = n / 2;
        	}
        	
        	
        	while(dept>0) {
        		int temp = map[a][b];
        		for(int i=b; i<m-1; i++) map[a][i] = map[a][i+1];
        		for(int i=a; i<n-1; i++) map[i][m-1] = map[i+1][m-1];
        		for(int i=m-1; i>b; i--) map[n-1][i] = map[n-1][i-1];
        		for(int i=n-1; i>a; i--) map[i][b] = map[i-1][b];
        		map[a+1][b] = temp;
        		a++; b++;
        		n -= 1; m -= 1; 
        		dept--;
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		System.out.print(map[i][j] + " ");
        	}
        	System.out.println();
        }
    }
        
}
