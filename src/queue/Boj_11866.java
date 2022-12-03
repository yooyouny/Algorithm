package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_11866 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb= new StringBuilder();

		int N = in.nextInt();
		int k = in.nextInt();
		for(int i=1; i<=N; i++){
			queue.offer(i);
		}
		sb.append("<");
		for(int j=0; j<N-1; j++) {
			for (int i = 0; i < k - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		sb.append(queue.poll() +">");
		System.out.println(sb);
	}
}
