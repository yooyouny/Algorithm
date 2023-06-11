import java.util.Scanner;

public class Main {
	static StringBuilder result = new StringBuilder();
	public static void getType(String[] input) {
		for (int i = 1; i < input.length; i++) {
			StringBuilder sb = new StringBuilder();
			String var = "";
			for (int j = 0; j < input[i].length(); j++) {
				char ch = input[i].charAt(j);
				if (ch == '*' || ch == '&') {
					sb.append(ch);
				} else if (ch == '[') {
					sb.append(']');
				} else if (ch == ']') {
					sb.append('[');
				} else if (('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')) {
					var += ch;
				}
			}
			result.append(input[0] + sb.reverse() + " " + var + ";\n");
		}
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		String line = sc.nextLine();
		line = line.replace(",", "").replace(";", "");
		String[] input = line.split(" ");
		getType(input);
		System.out.println(result.toString());
	}
}