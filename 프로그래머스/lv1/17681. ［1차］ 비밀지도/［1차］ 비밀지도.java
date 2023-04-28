class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String arr1Str = String.format("%"+n+"s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String arr2Str = String.format("%"+n+"s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            String colStr = "";
            for(int j=0; j<n; j++){
                char arr1Char = arr1Str.charAt(j);
                char arr2Char = arr2Str.charAt(j);
                if(arr1Char == '1' || arr2Char == '1'){
                    colStr += "#";
                }else if(arr1Char == '0' && arr2Char == '0'){
                    colStr += " ";
                }
            }
            answer[i] = colStr;
        }
        return answer;
    }
}