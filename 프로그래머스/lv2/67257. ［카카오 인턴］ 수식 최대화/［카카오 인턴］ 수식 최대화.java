import java.util.*;
class Solution {
    private long calculate(long first, long second, String op) {
        return switch (op) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> 0;
        };
    }
    private long calculate(List<String> inputList, String[] operator){
        for(String op : operator){
            for(int i=0; i<inputList.size(); i++){
                if(op.equals(inputList.get(i))){
                    long first = Long.parseLong(inputList.get(i - 1));
                    long second = Long.parseLong(inputList.get(i + 1));
                    inputList.remove(i-1);
                    inputList.remove(i-1);
                    inputList.remove(i-1);
                    inputList.add(i-1, String.valueOf(calculate(first, second, op)));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(inputList.get(0));
    }
    public long solution(String expression) {
        String[][] operators  = {{"+","-","*"},{"+","*","-"},
                                {"-","+","*"},{"-","*","+"},
                                {"*","+","-"},{"*","-","+"}};
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> inputList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            inputList.add(st.nextToken());
        }
        
        long answer = 0;
        for(String operator[] : operators){
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(inputList), operator)));
        }
        
        return answer;
    }
}