class Solution {
    public int solution(int n) {
        System.out.println(Integer.toString(n, 3));
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        return Integer.parseInt(sb.reverse().toString(), 3);
    }
}