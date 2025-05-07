import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] parse = br.readLine().split("-");
    int num = getSumOfGroup(parse[0]);
    for(int i=1; i<parse.length; i++) {
      num -= getSumOfGroup(parse[i]);
    }
    System.out.println(num);
  }
  public static int getSumOfGroup(String s) {
    int sum = 0;
    String[] numbers = s.split("\\+");
    for(String number : numbers){
      sum += Integer.parseInt(number);
    }
    return sum;
  }
}