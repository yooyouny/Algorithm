class Solution {
    public int combination(ArrayList<Character> list){
        // 조합코드 
        return 1;
    }
    public int solution(String numbers) {
        ArrayLIst<Character> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<numbers.length(); i++)
            list.add(numbers.charAt(i));
        answer = combination(list);
        return answer;
    }
}