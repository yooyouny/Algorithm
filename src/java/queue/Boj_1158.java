package java.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int k = sc.nextInt();
		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++){
			q.offer(i);
		}
		for(int i=0; i<N-1; i++){
			for(int j=0; j<k-1; j++){
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}
