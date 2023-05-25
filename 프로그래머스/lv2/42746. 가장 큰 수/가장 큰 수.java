import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .toArray(String[]::new);
        
        if(arr[0].equals("0")) return "0"; // 정렬된 가장 큰 수
        
        return String.join("", arr);
    }
}