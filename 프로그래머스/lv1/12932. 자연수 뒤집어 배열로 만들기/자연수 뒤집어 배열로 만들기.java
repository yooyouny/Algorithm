class Solution {
    public int[] solution(long n) {
        String number = String.valueOf(n);
        int[] digits = new int[number.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int)(n % 10);
            n /= 10;
        }
        return digits;
    }
}