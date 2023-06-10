class Solution {
    public int solution(String before, String after) {
        int[] beforeAlpha = new int[26];
        int[] afterAlpha = new int[26];
        for(int i=0; i<before.length(); i++){
            beforeAlpha[before.charAt(i) - 'a']++;
            afterAlpha[after.charAt(i) - 'a']++;
        }
        for(int i=0; i<beforeAlpha.length; i++){
            if(beforeAlpha[i] != afterAlpha[i])
                return 0;
        }
        return 1;
    }
}